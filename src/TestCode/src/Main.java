import javax.swing.plaf.IconUIResource;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {;
    static int evalCycles = 10000000;
    static int seedBound = 100000;
    static int resultDigits = 10;
    static long resultBound = (long) Math.pow(10, resultDigits);
    static double offsetTolerance = 0.1;
    static double levenshteinTolerance = 0.05;

    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<Long> results = new ArrayList<>(evalCycles);


        for (int i = 0; i < evalCycles; i++) {
            int seed = rnd.nextInt(seedBound);
            results.add(randomize(seed));
        }
        eval(results);
    }

    public static long randomize(long seed) {
        return seed * 100000 + seed;
    }

    public static void eval(ArrayList<Long> results) {
        long start = System.nanoTime();

        System.out.println("-------------------------------");
        System.out.println("Ziffernanalyse:");
        numberOccurenceAnalysis(results);
        System.out.println("-------------------------------");
        System.out.println("Levenshteinanalyse:");
        levenshteinDistanceAnalysis(results);
        System.out.println((double) (System.nanoTime() - start) / 1000000000 + " sekunden");
    }

    public static String addLeadingZeros(long number, int numDigits) {
        return String.format("%0"+numDigits+"d", number);
    }

    public static void predictionAnalysis(ArrayList<Long> results) {
        
    }

    public static void numberOccurenceAnalysis (ArrayList<Long> results) {
        Map<Character, Integer> countMap = new HashMap<>();

        for (Integer i = 0; i < 10; i++) {
            countMap.put(i.toString().charAt(0), 0);
        }

        for (Long result: results){
            String resultString = addLeadingZeros(result, resultDigits);
            for (char c: resultString.toCharArray()) {
                countMap.put(c, countMap.get(c) + 1);
            }
        }


        System.out.println("Die Ziffernverteilung von deinem Zufallsgenerator");
        DecimalFormat df = new DecimalFormat("###.#");

        countMap.forEach((k, v) -> System.out.println(k + " : " + df.format((double) v / evalCycles * 10) + " % = " + v));


        for (Character number : countMap.keySet()) {
            if (countMap.get(number) > evalCycles * (1 + offsetTolerance)) {
                System.out.println("Es sind tendenziell zu viele " + number + " in deinen Zufallszahlen Vorhanden.");
            }
            if (countMap.get(number) < evalCycles * (1 - offsetTolerance)) {
                System.out.println("Es sind tendenziell zu wenige " + number + " in deinen Zufallszahlen Vorhanden.");
            }
        }
    }

    public static void levenshteinDistanceAnalysis(ArrayList<Long> results) {
        String curString = "";
        String prevString = addLeadingZeros(results.getFirst(), resultDigits);
        long totalDistance = 0;
        Map<Integer, Long> allDistances = new HashMap<>();
        for (Integer i = 0; i < resultDigits; i++) {
            allDistances.put(i, 0L);
        }

        for (int i = 1; i < results.size(); i++) {
            curString = addLeadingZeros(results.get(i), resultDigits);

            for (int j = 0; j < curString.length(); j++) {
                try {
                    if (curString.charAt(j) != prevString.charAt(j)) {
                        totalDistance++;
                        allDistances.put(j, allDistances.get(j) + 1);
                    }
                } catch (Exception e) {
                    System.out.println(curString);
                    System.out.println(prevString);
                    throw e;
                }
            }
            prevString = curString;
        }

        double avgDistance = (double) totalDistance / (results.size() - 1);

        long expectedDist = Math.round(Math.log10(resultBound) - 1);

        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println("Die Durchschnittliche Levenshtein Distanz zwischen deinen generierten Zufallszahlen ist: " + df.format(avgDistance));
        System.out.println("Der Erwartungswert hierfür ist: " + expectedDist);
        if (avgDistance > expectedDist + expectedDist * levenshteinTolerance || avgDistance < expectedDist - expectedDist * levenshteinTolerance ){
            System.out.println("Versuch näher an den Erwartungswert ranzukommen.");
        }

        System.out.println("Die Levenshtein Distanz, nach den Stellen in der Ergebniszahl aufgeschlüsselt sieht so aus:");
        System.out.println("Der Erwartungswert für jede einzelne Stelle ist 0,9");

        allDistances.forEach((k, v) -> System.out.println(k + " : " + df.format((double) v / evalCycles)));

        for (Integer position : allDistances.keySet()){
            if ((double) allDistances.get(position) / evalCycles < (double) expectedDist / 10 * (1 - levenshteinTolerance)) {
                System.out.println("Es ist tendenziell zu wenig Variation an der " + position + ". Stelle deiner Zufallszahlen Vorhanden.");
            }
            if ((double) allDistances.get(position) / evalCycles > (double) expectedDist / 10 * (1 + levenshteinTolerance)) {
                System.out.println("Es ist tendenziell zu viel Variation an der " + position + ". Stelle deiner Zufallszahlen Vorhanden.");
            }
        }
    }
}