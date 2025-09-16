import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Day1Highperformer {;
    public static long randomize(long seed) {
        long ausgabeZahl = 0;
        // VON HIER seed nehmen und basierend darauf eine 10-stellige Zahl machen







        // BIS HIER die fertige Zahl dann in der Variable ausgabeZahl speichern
        // um dein Verfahren zu testen, einfach den Code in dieser Datei ausführen
        return ausgabeZahl;
    }


    static int evalCycles = 10000000;
    static int seedBound = 100000;
    static int resultDigits = 10;
    static long resultBound = (long) Math.pow(10, resultDigits);
    static double offsetTolerance = 0.1;
    static double levenshteinTolerance = 0.05;
    static double predictionTolerance = 0.1;

    public static void main(String[] args) {
        Random rnd = new Random();
        long[] results = new long[evalCycles];

        for (int i = 0; i < evalCycles; i++) {
            int seed = rnd.nextInt(seedBound);
            results[i] = randomize(seed);
        }
        eval(results);
    }

    public static void eval(long[] results) {
        long start = System.nanoTime();

        System.out.println("-------------------------------");
        System.out.println("Determinismusanalyse:");
        int numDeterminismTests = 5;
        for (int i = 0; i < numDeterminismTests; i++) {
            if (randomize(results[i]) != randomize(results[i])) {
                System.out.println("Dein Algorithmus soll bei gleichem Seed immer ein die gleiche Ausgabezahl ausgeben");
                return;
            }
        }
        System.out.println("Dein Algorithmus ist im Kontext vom seed Deterministisch :)");
        System.out.println((double) (System.nanoTime() - start) / 1000000000 + " sekunden");
        start = System.nanoTime();
        System.out.println("-------------------------------");
        System.out.println("Ziffernanalyse:");
        if(!numberOccurenceAnalysis(results)){
            System.out.println("Probier dafür zu sorgen, dass die Wahrscheinlichkeit für jede Ziffer gleich hoch wird.");
            return;
        }
        System.out.println((double) (System.nanoTime() - start) / 1000000000 + " sekunden");
        start = System.nanoTime();
        System.out.println("-------------------------------");
        System.out.println("Levenshteinanalyse (https://de.wikipedia.org/wiki/Levenshtein-Distanz):");
        if(!levenshteinDistanceAnalysis(results)) {
            System.out.println("Probier dafür zu sorgen, dass die unterschiedlichen Ergebnisse keine Musterartigen Ähnlichkeiten aufweisen.");
            return;
        }
        System.out.println((double) (System.nanoTime() - start) / 1000000000 + " sekunden");
        System.out.println("-------------------------------");
        System.out.println("Ziffernkorrelationsanalyse:");
        if(!predictionAnalysis(results)) {
            System.out.println("Probier dafür zu sorgen, dass alle Ausgabeziffern unabhängig voneinander sind.");
            return;
        } else {
            System.out.println("Sehr gut gemacht!");
        }
        System.out.println((double) (System.nanoTime() - start) / 1000000000 + " sekunden");
    }

    public static String addLeadingZeros(long number, int numDigits) {
        return String.format("%0"+numDigits+"d", number);
    }

    public static boolean predictionAnalysis(long[] results) {
        long[][] occurrence = new long[resultDigits][10];
        long[][][][] prediction = new long[resultDigits][10][resultDigits][10];

        for (int i = 0; i < results.length; i++) {
            char[] digits = addLeadingZeros(results[i], resultDigits).toCharArray();

            for (int digitPos = 0; digitPos < resultDigits; digitPos++) {
                int digit = digits[digitPos] - '0';
                occurrence[digitPos][digit]++;

                for (int predictedPos = 0; predictedPos < resultDigits; predictedPos++) {
                    int predicted = digits[predictedPos] - '0';
                    prediction[digitPos][digit][predictedPos][predicted]++;
                }
            }
        }

        double expectedProbability = 0.1;
        int maxOutputLines = 3;
        int outputLines = 0;
        boolean komprimiert = false;
        Scanner sc = new Scanner(System.in);

        for (int predictorPos = 0; predictorPos < resultDigits; predictorPos++) {
            for (int digit = 0; digit < resultDigits; digit++) {
                long predictorOccurences = occurrence[predictorPos][digit];

                for (int predictedPos = predictorPos; predictedPos < resultDigits; predictedPos++) {
                    for (int predictedDigit = 0; predictedDigit < resultDigits; predictedDigit++) {
                        double predictionProbability = (double) prediction[predictorPos][digit][predictedPos][predictedDigit] / (double) occurrence[predictorPos][digit];

                        DecimalFormat df = new DecimalFormat("###.#");
                        String predictionProbString = df.format(predictionProbability * 100);

                        int numLines = 0;
                        if ((predictionProbability > expectedProbability + expectedProbability * predictionTolerance || predictionProbability < expectedProbability - expectedProbability * predictionTolerance) && outputLines <= maxOutputLines && predictorPos != predictedPos) {
                            if (!komprimiert) {
                                System.out.println("Eine " + digit + " an Stelle " + predictorPos + " tritt zu " + predictionProbString + "% mit einer " + predictedDigit + " an Stelle " + predictedPos + " auf. Der Erwartungswert ist hierfür ist 10%");
                            } else {
                                //System.out.println(digit + " bei " + predictorPos + " =" + predictionProbability * 100 + "%=> " + predictedDigit +  " bei " + predictedPos)
                                String outputString = "";
                                outputString = outputString + "X".repeat(predictorPos);
                                outputString = outputString + Integer.toString(digit);
                                outputString = outputString + "X".repeat(resultDigits - 1 - predictorPos);
                                outputString = outputString + "  <--- " + " ".repeat(5 - predictionProbString.length()) + predictionProbString + "% ---> ";
                                outputString = outputString + "X".repeat(predictedPos);
                                outputString = outputString + Integer.toString(predictedDigit);
                                outputString = outputString + "X".repeat(resultDigits - 1 - predictedPos);

                                System.out.println(outputString);
                                System.out.println("--------------------------------------");
                            }
                            outputLines++;
                        } else if (outputLines >= maxOutputLines) {

                            System.out.println("Es gibt noch mehr über- oder unterdurchschnittliche Korrelationen, die hier aus Platzgründen noch nicht ausgegeben wurden.");
                            System.out.print("Hättest du gerne alle Korrelationen in komprimierter Form ausgegegeben? (gib j oder n für ja oder nein ein):");
                            String doAusfuehrlich = sc.next();

                            if (doAusfuehrlich.equals("j")) {
                                maxOutputLines = Integer.MAX_VALUE;
                                komprimiert = true;
                                System.out.println();
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        if (outputLines == 0) {
            System.out.println("Keine außerordentlichen Korrelationen entdeckt :)");
            return true;
        } else {
            return false;
        }
    }

    public static boolean numberOccurenceAnalysis (long[] results) {
        long[] digitCounter = new long[resultDigits];

        for (long result: results){
            String resultString = addLeadingZeros(result, resultDigits);
            for (Character c: resultString.toCharArray()) {
                digitCounter[c - '0']++;
            }
        }

        System.out.println("Die Ziffernverteilung von deinem Zufallsgenerator");
        DecimalFormat df = new DecimalFormat("###.#");

        for (int digit = 0; digit < digitCounter.length; digit++) {
            System.out.println(digit + " : " + df.format( (double) digitCounter[digit] / evalCycles * 10) + " % = " + digitCounter[digit]);
        }

        boolean noProblems = true;
        for (int digit = 0; digit < digitCounter.length; digit++) {
            if (digitCounter[digit] > evalCycles * (1 + offsetTolerance)) {
                System.out.println("Es sind tendenziell zu viele " + digit + " in deinen Zufallszahlen Vorhanden.");
                noProblems = false;
            }
            if (digitCounter[digit] < evalCycles * (1 - offsetTolerance)) {
                System.out.println("Es sind tendenziell zu wenige " + digit + " in deinen Zufallszahlen Vorhanden.");
                noProblems = false;
            }
        }
        if (noProblems){
            System.out.println("Alle Ziffern kommen Gleichverteilt vor :)");
        }
        return noProblems;
    }


    public static boolean levenshteinDistanceAnalysis(long[] results) {
        long totalDistance = 0;
        String prevString = addLeadingZeros(results[0], resultDigits);

        long[] digitDistances = new long[resultDigits];
        for (int i = 1; i < results.length; i++) {
            String curString = addLeadingZeros(results[i], resultDigits);

            // Compare characters position by position
            for (int j = 0; j < resultDigits; j++) {
                if (curString.charAt(j) != prevString.charAt(j)) {
                    totalDistance++;
                    digitDistances[j]++;
                }
            }
            prevString = curString;
        }

        double avgDistance = (double) totalDistance / (results.length - 1);

        long expectedDist = Math.round(Math.log10(resultBound) - 1);

        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println("Die Durchschnittliche Levenshtein Distanz zwischen deinen generierten Zufallszahlen ist: " + df.format(avgDistance));
        System.out.println("Der Erwartungswert hierfür ist: " + expectedDist);
        if (avgDistance > expectedDist + expectedDist * levenshteinTolerance || avgDistance < expectedDist - expectedDist * levenshteinTolerance ){
            System.out.println("Versuch näher an den Erwartungswert ranzukommen.");
        }

        System.out.println("Die Levenshtein Distanz, nach den Stellen in der Ergebniszahl aufgeschlüsselt sieht so aus:");
        System.out.println("Der Erwartungswert für jede einzelne Stelle ist 0,9");


        for (int i = 0; i < resultDigits; i++) {
            double digitAvg = (double) digitDistances[i] / (results.length - 1);
            System.out.println(i + " : " + df.format(digitAvg));
        }

        boolean noProblems = true;
        for (int i = 0; i < resultDigits; i++) {
            if ((double) digitDistances[i] / evalCycles < (double) expectedDist / 10 * (1 - levenshteinTolerance)) {
                System.out.println("Es ist tendenziell zu wenig Variation an der " + i + ". Stelle deiner Zufallszahlen Vorhanden.");
                noProblems = false;
            }
            if ((double) digitDistances[i] / evalCycles > (double) expectedDist / 10 * (1 + levenshteinTolerance)) {
                System.out.println("Es ist tendenziell zu viel Variation an der " + i + ". Stelle deiner Zufallszahlen Vorhanden.");
                noProblems = false;
            }
        }
        if (noProblems) {
            System.out.println("Die Ausgabezahlen sind nach Levenshtein Distanz unabhängig voneinander :)");
        }
        return noProblems;
    }
}