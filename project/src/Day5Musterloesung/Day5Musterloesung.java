import java.util.HashMap;
import java.util.Map;

public class Day5Musterloesung {
    // Aufgabe 1
    System.out.println("Paul Griller: " + map.get("Paul Griller"));

    // Aufgabe 2
    public static void Aufgabe12(String text) {
        String[] letters = text.split("");
        Map<String, Long> letterMap = new HashMap<>();
        for (String letter : letters) {
            if (letterMap.containsKey(letter)) {
                letterMap.put(letter, letterMap.get(letter) + 1);
            } else {
                letterMap.put(letter, 1L);
            }
        }
        Aufgabe11(letterMap);
    }

    public static void Aufgabe13(String text, int length) {
        Map<String, Long> sequenceMap = new HashMap<>();

        /*for (int i = 0; i <= text.length() - length; i++) {
            String sequence = text.substring(i, i + length);
            if (sequenceMap.containsKey(sequence)) {
                sequenceMap.put(sequence, sequenceMap.get(sequence) + 1);
            } else {
                sequenceMap.put(sequence, 1L);
            }
        }*/

        String[] sequences = text.split("");
        String sequence;

        for (int i = 0; i < sequences.length - length; i++) {
            sequence = "";
            for (int j = 0; j < length; j++) {
                sequence += sequences[i + j];
            }

            if (sequenceMap.containsKey(sequence)) {
                sequenceMap.put(sequence, sequenceMap.get(sequence) + 1);
            } else {
                sequenceMap.put(sequence, 1L);
            }
        }

        Aufgabe11(sequenceMap);
    }

    public static void main(String[] args) {
        Map<String, Long> telefonbuch = new HashMap<>();
        telefonbuch.put("Paul Griller", 1374927394L);
        telefonbuch.put("Menalie Barbecue", 9257632984L);

        Aufgabe11(telefonbuch);
        Aufgabe12("grimmige griller grillen glühend gern grobe grillgemüse-spieße.");
        Aufgabe13("grimmige griller grillen glühend gern grobe grillgemüse-spieße.", 3);
    }
}
