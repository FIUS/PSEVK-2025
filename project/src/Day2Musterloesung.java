import java.util.Scanner;

public class Day2Musterloesung {
    public static void main(String[] args) {
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

    // vielleicht Highperformer 
    import java.util.Random;
import java.util.Scanner;

class Scratch {
    public static final String GREEN = "\u001B[92m";
    public static final String YELLOW = "\u001B[93m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int ergebnis = random.nextInt(1000, 10000);
        int versuche = 1;

        while (true) {
            System.out.print("vier stellige Zahl eingeben: ");
            int spielerGuess = scanner.nextInt();

            if (spielerGuess < 1000 || spielerGuess > 9999) {
                System.out.println("Fehler: Die Zahl muss genau 4 Ziffern haben!");
                continue;
            }

            if (ergebnis == spielerGuess) {
                System.out.println(GREEN + "Jaaa! Richtig geraten. Benötigte Versuche: " + versuche + RESET);
                break;
            }

            //Zahl in stellen zerlegen
            int aktuelleZahl = spielerGuess;
            int aktuelleErgebnis = ergebnis;

            // mit mod 10 erhalten wir die letzte Stelle
            int spielerStelle4 = aktuelleZahl % 10;
            aktuelleZahl = aktuelleZahl / 10;
            int spielerStelle3 = aktuelleZahl % 10;
            aktuelleZahl = aktuelleZahl / 10;
            int spielerStelle2 = aktuelleZahl % 10;
            aktuelleZahl = aktuelleZahl / 10;
            int spielerStelle1 = aktuelleZahl % 10;

            // mit mod 10 erhalten wir die letzte Stelle
            int ergebnisStelle4 = aktuelleErgebnis % 10;
            aktuelleErgebnis = aktuelleErgebnis / 10;
            int ergebnisStelle3 = aktuelleErgebnis % 10;
            aktuelleErgebnis = aktuelleErgebnis / 10;
            int ergebnisStelle2 = aktuelleErgebnis % 10;
            aktuelleErgebnis = aktuelleErgebnis / 10;
            int ergebnisStelle1 = aktuelleErgebnis % 10;

            String output1 = "_", output2 = "_", output3 = "_", output4 = "_";

            //checken ob einzelne Stellen schon richtig sind
            boolean stelle1richtig = ergebnisStelle1 == spielerStelle1;
            boolean stelle2richtig = ergebnisStelle2 == spielerStelle2;
            boolean stelle3richtig = ergebnisStelle3 == spielerStelle3;
            boolean stelle4richtig = ergebnisStelle4 == spielerStelle4;

            if (stelle1richtig) {
                ergebnisStelle1 = 42;
                output1 = GREEN + spielerStelle1 + RESET + " ";
            }
            if (stelle2richtig) {
                ergebnisStelle2 = 42;
                output2 = GREEN + spielerStelle2 + RESET + " ";
            }
            if (stelle3richtig) {
                ergebnisStelle3 = 42;
                output3 = GREEN + spielerStelle3 + RESET + " ";
            }
            if (stelle4richtig) {
                ergebnisStelle4 = 42;
                output4 = GREEN + spielerStelle4 + RESET + " ";
            }


            if (!stelle1richtig) {
                if (spielerStelle1 == ergebnisStelle2) {
                    ergebnisStelle2 = 42;
                    output1 = YELLOW + spielerStelle1 + RESET + " ";
                } else if (spielerStelle1 == ergebnisStelle3) {
                    ergebnisStelle3 = 42;
                    output1 = YELLOW + spielerStelle1 + RESET + " ";
                } else if (spielerStelle1 == ergebnisStelle4) {
                    ergebnisStelle4 = 42;
                    output1 = YELLOW + spielerStelle1 + RESET + " ";
                } else {
                    output1 = spielerStelle1 + " ";
                }
            }

            if (!stelle2richtig) {
                if (spielerStelle2 == ergebnisStelle1) {
                    ergebnisStelle1 = 42;
                    output2 = YELLOW + spielerStelle2 + RESET + " ";
                } else if (spielerStelle2 == ergebnisStelle3) {
                    ergebnisStelle3 = 42;
                    output2 = YELLOW + spielerStelle2 + RESET + " ";
                } else if (spielerStelle2 == ergebnisStelle4) {
                    ergebnisStelle4 = 42;
                    output2 = YELLOW + spielerStelle2 + RESET + " ";
                } else {
                    output2 = spielerStelle2 + " ";
                }
            }


            if (!stelle3richtig) {
                if (spielerStelle3 == ergebnisStelle1) {
                    ergebnisStelle1 = 42;
                    output3 = YELLOW + spielerStelle3 + RESET + " ";
                } else if (spielerStelle3 == ergebnisStelle2) {
                    ergebnisStelle2 = 42;
                    output3 = YELLOW + spielerStelle3 + RESET + " ";
                } else if (spielerStelle3 == ergebnisStelle4) {
                    ergebnisStelle4 = 42;
                    output3 = YELLOW + spielerStelle3 + RESET + " ";
                } else {
                    output3 = spielerStelle3 + " ";
                }
            }

            if (!stelle4richtig) {
                if (spielerStelle4 == ergebnisStelle1) {
                    ergebnisStelle1 = 42;
                    output4 = YELLOW + spielerStelle4 + RESET + " ";
                } else if (spielerStelle4 == ergebnisStelle2) {
                    ergebnisStelle2 = 42;
                    output4 = YELLOW + spielerStelle4 + RESET + " ";
                } else if (spielerStelle4 == ergebnisStelle3) {
                    ergebnisStelle3 = 42;
                    output4 = YELLOW + spielerStelle4 + RESET + " ";
                } else {
                    output4 = spielerStelle4 + " ";
                }
            }

            System.out.println("Auswertung: " + output1 + output2 + output3 + output4);
            System.out.println("--------------------------------");

            versuche++;
        }
    }
}


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
