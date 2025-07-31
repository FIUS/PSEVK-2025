import javax.swing.plaf.IconUIResource;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {;
    static int evalCycles = 100000;
    static int seedBound = 100000;
    static long resultBound = 10000000000L;
    static int resultDigits = 10;
    static double offsetTolerance = 0.1;

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

        numberOccurenceAnalysis(results);
        System.out.println((System.nanoTime() - start) / 10000000);
    }

    public static void levenshteinDistanceAnalysis(ArrayList<Long> results) {
        String curString = "";
        String prevString = results.getFirst().toString();
        long totalDistance = 0;

        for (int i = 1; i < results.size(); i++) {
            curString = addLeadingZeros(results.get(i), resultDigits);

            for (int j = 0; j < curString.length(); j++) {
                if (curString.charAt(j) != prevString.charAt(j)) {
                    totalDistance++;
                }
            }
            prevString = curString;
        }

        
    }

    public static String addLeadingZeros(long number, int numDigits) {
        return String.format("%0"+numDigits+"d", number);
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

        countMap.forEach((k, v) -> System.out.println(k + " : " + df.format((double) v / seedBound * 10) + " % = " + v));


        for (Character number : countMap.keySet()) {
            if (countMap.get(number) > seedBound * (1 + offsetTolerance)) {
                System.out.println("Es sind tendenziell zu viele " + number + " in deinen Zufallszahlen Vorhanden.");
            }
            if (countMap.get(number) < seedBound * (1 - offsetTolerance)) {
                System.out.println("Es sind tendenziell zu wenige " + number + " in deinen Zufallszahlen Vorhanden.");
            }
        }
    }
}