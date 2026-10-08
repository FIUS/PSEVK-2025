import java.util.HashMap;
import java.util.Map;

public class Day5Musterloesung {
    
    public static void main(String[] args) {
        // 1.1
        HashMap<String, Long> telefonbuch = new HashMap<String, Long>();
        telefonbuch.put("Paul Griller", 1374927394L);
        telefonbuch.put("Melanie Barbecue", 9257632984L);

        System.out.println("Paul Griller hat folgende Telefonnummer: " + telefonbuch.get("Paul Griller"));

        // 1.2
        printMap(telefonbuch);

    }
    

    // 1.2
    public static void printMap(Map<String, Long> map) {
        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.keySet().toArray()[i] + ": " + map.values().toArray()[i]);
        }
    }

    // 1.3
    public static void countLetters(String text) {
        String[] letters = text.split("");

        HashMap<String, int> letterMap = new HashMap<>();

        for (int i = 0; i < letters.length; i++) {
            String letter = letters[i];
            if (letterMap.containsKey(letter)) {
                letterMap.put(letter, letterMap.get(letter) + 1);
            } else {
                letterMap.put(letter, 1);
            }
        }
        printMap(letterMap);
    }

    // 1.4
    public static void countSequences(String text, int length) {
        HashMap<String, Long> sequenceMap = new HashMap<>();

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

        printMap(sequenceMap);
    }

    
}
