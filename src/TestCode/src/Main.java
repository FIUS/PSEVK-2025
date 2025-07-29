import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int evalCycles = 100000;
    static int seedBound = 100000;
    static long resultBound = 10000000000L;
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

        String resultString = results.stream()
                .map(num -> String.format("%010d", num))
                .collect(Collectors.joining());

        Map<Character, Long> countMap = resultString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println("Die Ziffernverteilung von deinem Zufallsgenerator");

        DecimalFormat df = new DecimalFormat("###.#");
        countMap.forEach((k, v) -> System.out.println(k + " : " + df.format((double) v / seedBound * 10) + " % = " + v));


        for (long v : countMap.values()) {
            if (v > seedBound * (1 + offsetTolerance)) {
                return;//TODO
            }
        }
    }
}