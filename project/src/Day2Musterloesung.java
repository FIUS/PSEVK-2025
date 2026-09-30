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

        //Aufgabe 1 NEU 
        // 1.1
        Scanner scanner = new Scanner(System.in);

        String passwort = "LeckerBierchen";

        while (true) {
            System.out.print("Passwort eingeben: ");
            String momentaneEingabe = scanner.nextLine();

            if (momentaneEingabe.equals(passwort)) {
                System.out.println("Passwort richtig, erfolgreich eingeloggt!");
                break;
            }
            System.out.println("Passwort falsch!");
        }

        // 1.2 
        Scanner scanner = new Scanner(System.in);

        String passwort = "LeckerBierchen";
        int anzahlVersuche = 0;

        while (true) {
            if (anzahlVersuche == 3){
                System.out.println("Vorgang abgebrochen zu viele Fehlversuche!");
                break;
            }
            System.out.print("Passwort eingeben: ");
            String momentaneEingabe = scanner.nextLine();

            anzahlVersuche ++;

            if (momentaneEingabe.equals(passwort)) {
                System.out.println("Passwort richtig, erfolgreich eingeloggt!");
                break;
            }
            System.out.println("Passwort falsch!");
        }

        // 1.3
        // Alternativ genauso mit erster abfrage vor while und while(SpielerTipp != result) lösbar 
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int result = random.nextInt(101);

        while (true) {
            System.out.print("Dein Tipp: ");
            int spielerTipp = scanner.nextInt();

            if (spielerTipp < result){
                System.out.println("Die gesuchte Zahl ist größer als " + spielerTipp);
            } else if (spielerTipp > result){
                System.out.println("Die gesuchte Zahl ist kleiner als " + spielerTipp);
            }else {
                break;
            }
        }
        System.out.println("Richtig geraten! Die gesuchte Zahl war " + result);

        // Aufgabe 2 NEU
        // 2.1
        Scanner scanner = new Scanner(System.in);

        System.out.print("Startkapital eingeben: ");
        double kapital = scanner.nextDouble();

        System.out.print("Zinssatz in % eingeben: ");
        double zinssatz = scanner.nextDouble();

        System.out.print("Laufzeit eingeben: ");
        int laufzeit = scanner.nextInt();

        for (int jahr = 1 ; jahr <= laufzeit; jahr++){
            kapital = kapital * (1 + zinssatz / 100.0);
            System.out.println("Der Kontostand nach Jahr " + jahr + " beträgt: " + kapital);
        }

        // 2.2
        Scanner scanner = new Scanner(System.in);

        System.out.print("Startkapital eingeben: ");
        double kapital = scanner.nextDouble();

        System.out.print("Zinssatz in % eingeben: ");
        double zinssatz = scanner.nextDouble();

        System.out.print("Laufzeit eingeben: ");
        int laufzeit = scanner.nextInt();

        System.out.print("Monatliche Sparrate eingeben: ");
        double sparrate = scanner.nextDouble();

        for (int jahr = 1 ; jahr <= laufzeit; jahr++){
            for (int monat = 1; monat <= 12; monat++){
                kapital = kapital + sparrate;
                kapital = kapital * (1 + (zinssatz / 100.0) / 12.0);
            }
            System.out.println("Der Kontostand nach Jahr " + jahr + " beträgt: " + kapital);
        }
        
        // Aufgabe 3 NEU 
        // 3.1
        Scanner scanner = new Scanner(System.in);

        System.out.print("Zahl eingeben: ");
        int zahl = scanner.nextInt();

        int anzahlStellen = 0;
        int aktuelleZahl = zahl;

        while (aktuelleZahl > 0){
            // hier machen wir uns die Ganzzahldivision zunutze da Nachkommastellen aufgrund von int abgeschnitten werden
            aktuelleZahl = aktuelleZahl / 10;
            anzahlStellen ++;
        }
        System.out.println(zahl + " hat " + anzahlStellen + " Stellen");

        // 3.2
        Scanner scanner = new Scanner(System.in);

        System.out.print("Zahl eingeben: ");
        int zahl = scanner.nextInt();

        int quersumme = 0;
        int aktuelleZahl = zahl;

        while (aktuelleZahl > 0){
            // mit mod 10 erhalten wir die letzte Stelle
            quersumme = quersumme + aktuelleZahl % 10;
            aktuelleZahl = aktuelleZahl / 10;
        }
        System.out.println("Die Quersumme von " + zahl + " ist " + quersumme);

        // 3.3
        Scanner scanner = new Scanner(System.in);

        System.out.print("Zahl eingeben: ");
        int zahl = scanner.nextInt();

        long multiplikator = 1;
        int aktuelleZahl = zahl;

        while (aktuelleZahl > 0){
            multiplikator = multiplikator * 10;
            aktuelleZahl = aktuelleZahl / 10;
        }
        long doppelt = (long) zahl * multiplikator + zahl;
        System.out.println(zahl + " zweimal hintereinander geschrieben ergibt: " + doppelt);

        // 3.4
        Scanner scanner = new Scanner(System.in);

        System.out.print("Zahl eingeben: ");
        int zahl = scanner.nextInt();

        int umgedreht = 0;
        int aktuelleZahl = zahl;

        while (aktuelleZahl > 0){
            int letzteZiffer = aktuelleZahl % 10;
            umgedreht = umgedreht * 10 + letzteZiffer;
            aktuelleZahl = aktuelleZahl / 10;
        }
        System.out.println(zahl + " umgedreht geschrieben ergibt: " + umgedreht);

        // 3.5
        
        // hier lediglich folgende if Abfrage an 3.4 anhängen

        if (umgedreht == zahl){
            System.out.println(zahl + " ist ein Palindrom");
        } else {
            System.out.println(zahl + " ist kein Palindrom");
        }


        // Aufgabe 3 ALT kommt weg!!
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
