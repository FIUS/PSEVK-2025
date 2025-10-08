import java.util.Scanner;

public class Day2Musterloesung {
    public static void main(String[] args) {
        // Aufgabe 1
        Scanner sc = new Scanner(System.in);

        // 1.1 + 1.2
        System.out.print("Wie Alt bist du: ");
        int alter = sc.nextInt();
        if (alter >= 18) {
            System.out.println("Herzlich Willkommen zur UNO");


            System.out.print("Bist du ein Ersti (true oder false eingeben)? ");
            boolean ersti = sc.nextBoolean();
            int preis = 7;
            if (ersti) {
                preis = 3;
            }
            System.out.println("Für dich sinds " + preis + " Euro");
        } else {
            System.out.println("Sorry, du darfst noch nicht rein :/");
        }

        // 1.3
        System.out.print("Wie viel Geld hast du? ");
        int geld = sc.nextInt();
        System.out.print("Wie viele Shots hättest du gerne: ");
        int shots = sc.nextInt();
        System.out.print("Wie viele Softdrinks hättest du gerne: ");
        int softdrinks = sc.nextInt();
        System.out.print("Wie viele Biere hättest du gerne: ");
        int biere = sc.nextInt();

        int gesamt = shots * 1 + softdrinks * 2 + biere * 2;
        System.out.println("Das sind insgesamt " + gesamt + " Euro");
        if (gesamt <= geld) {
            System.out.println("Das reicht für die Bestellung :)");
        } else {
            System.out.println("Du hast zu wenig Geld dabei");
        }

        // Aufgabe 2
        // 2.1 (arbeitet mit den Variablen aus 1)
        if (gesamt <= geld) {
            for (int i = 0; i < shots; i++) {
                System.out.println("Shot " + i + " ist eingeschenkt");
            }
            for (int i = 0; i < softdrinks; i++) {
                System.out.println("Softdrink " + i + " ist fertig");
            }
            for (int i = 0; i < biere; i++) {
                System.out.println("Bier " + i + " ist geöffnet");
            }
        }

        // 2.2
        int geld2 = -1;
        int gesamt2 = 0;


        while (geld2 <= gesamt2) {
            System.out.print("Wie viel Geld hast du? ");
            geld2 = sc.nextInt();
            System.out.print("Wie viele Shots hättest du gerne: ");
            int shots2 = sc.nextInt();
            System.out.print("Wie viele Softdrinks hättest du gerne: ");
            int softdrinks2 = sc.nextInt();
            System.out.print("Wie viele Biere hättest du gerne: ");
            int biere2 = sc.nextInt();

            gesamt2 = shots2 * 1 + softdrinks2 * 2 + biere2 * 2;
            System.out.println("Das sind insgesamt " + gesamt + " Euro");
            if (gesamt2 <= geld2) {
                System.out.println("Das reicht für die Bestellung :)");
                break;
            } else {
                System.out.println("Du hast zu wenig Geld dabei, probier eine andere Bestellung");
            }
        }

        // Aufgabe 3
        // 3.1
        System.out.print("Gib eine Zahl ein: ");
        double zahl = sc.nextDouble();
        double stellen = Math.ceil(Math.log10(zahl));
        zahl = zahl + zahl * Math.pow(10, stellen);
        System.out.println("Die Zahl zwei mal hintereinander: " + Math.round(zahl));

        // 3.2
        System.out.print("Gib eine Zahl ein: ");
        double zahl2 = sc.nextDouble();
        double stellen2 = Math.ceil(Math.log10(zahl2));

        boolean palindrom = true;
        for (int i = 0; i < Math.floor(stellen2 / 2); i++) {
            double hoheZiffer = Math.floor(zahl2 / Math.pow(10, stellen2 - i - 1)) % 10;
            double niedrigeZiffer = Math.floor(zahl2 / Math.pow(10, i) % 10);
            if (hoheZiffer != niedrigeZiffer) {
                palindrom = false;
            }
        }

        if (palindrom) {
            System.out.println("Die Zahl ist ein Palindrom");
        } else {
            System.out.println("Die Zahl ist kein Palindrom");
        }

        // 3.3
        System.out.print("Gib eine Zahl ein: ");
        double zahl3 = sc.nextDouble();
        double stellen3 = Math.ceil(Math.log10(zahl3));

        double zahl3Rueckwaerts = 0;
        for (int i = 1; i <= stellen3; i++) {
            double ziffer = Math.floor(zahl3 % Math.pow(10, i) / Math.pow(10, i - 1));
            zahl3Rueckwaerts = zahl3Rueckwaerts + ziffer * Math.pow(10, stellen3 - i);
        }

        System.out.println("Die Zahl rückwärts ist: " + Math.round(zahl3Rueckwaerts));


        // Highperformer
        int numVars = 8;

        int wahr = 0;
        int falsch = 0;

        boolean erfuellbar = false;
        boolean tautologie = true;
        boolean unerfuellbar = true;

        for (int i = 0; i < Math.pow(2, numVars); i++) {
            String binary = Integer.toBinaryString(i);
            System.out.println(binary);

            while (binary.length() < numVars) {
                binary = "0" + binary;
            }

            boolean a = binary.charAt(0) == '1';
            boolean b = binary.charAt(1) == '1';
            boolean c = binary.charAt(2) == '1';
            boolean d = binary.charAt(3) == '1';
            boolean e = binary.charAt(4) == '1';
            boolean f = binary.charAt(5) == '1';
            boolean g = binary.charAt(6) == '1';
            boolean h = binary.charAt(7) == '1';

            // hier die Boole'schen Formeln reinkopieren
            if (((a && b && !c && !d && !e) || (!a && c && d && !b && !e) || (!b && !c
                    && !d && e && f)) && (!g || h)) {
                wahr++;
                erfuellbar = true;
                unerfuellbar = false;
            } else {
                falsch++;
                tautologie = false;
            }
        }

        System.out.println("Die Formel ist erfüllbar ist: " + erfuellbar);
        System.out.println("Die Formel ist unerfüllbar ist: " + unerfuellbar);
        System.out.println("Die Formel ist eine Tautologie ist: " + tautologie);
        System.out.println("Die Formel wird bei " + wahr + " von " + (int) Math.pow(2, numVars) + " Belegungen wahr");
        System.out.println("Die Wahrscheinlichkeit das die Formel bei einer zufälligen Belegung wahr wird ist " + wahr / Math.pow(2, numVars) * 100 + "%");
    }
}
