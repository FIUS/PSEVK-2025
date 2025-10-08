public class Day3Musterloesung {
    public static void main(String[] args) {
        // Aufgabe 1

        ankuendigung();
        System.out.println(ankuendigungRueckgabe());
        namensAnkuendigung("Melanie");
        System.out.println(addierer(3, 5));
        System.out.println(multiplizierer(3, 5));
        System.out.println(fakultaet(5));

        // Aufgabe 2
        // Aufgabe 2.1

        int[] einArray = new int[10];
        System.out.println(einArray);


    }

    // Aufgabe 1
    // 1.1
    public static void ankuendigung() {
        System.out.println("Es ist Grillereizeit meine Freunde!");
    }

    // 1.2
    public static String ankuendigungRueckgabe() {
        return "Es ist Grillereizeit meine Freunde!";
    }

    // 1.3
    public static void namensAnkuendigung(String name) {
        System.out.println("Komm ran " + name + " es gibt Grillung!");
    }

    // 1.4
    public static int addierer(int zahl1, int zahl2) {
        int summe = zahl1;
        for (int i = 0; i < zahl2; i++) {
            summe++;
        }
        return summe;
    }

    // 1.5
    public static int multiplizierer(int zahl1, int zahl2) {
        int produkt = 0;
        for (int i = 0; i < zahl2; i++) {
            produkt = addierer(produkt, zahl1);
        }
        return produkt;
    }

    // 1.6
    public static int fakultaet(int zahl) {
        int ergebnis = 1;
        for (int i = zahl; i > 0; i--) {
            ergebnis = ergebnis * i;
        }
        return ergebnis;
    }

    // Aufgabe 2
    // 2.2
    public static void arrayPrint (int[] einArray) {
        for (int i = 0; i < einArray.length; i++) {
            System.out.print(einArray[i] + " ");
        }
    }

    // 2.3
    public static void arrayPrint2D (int[][] einArray) {
        for (int i = 0; i < einArray.length; i++) {
            for (int j = 0; j < einArray[i].length; j++) {
                System.out.print(einArray[i][j] + " ");
            }
        }
    }
}
