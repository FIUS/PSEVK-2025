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

import java.util.Random;
import java.util.Scanner;

class Scratch {
    public static final String GREEN = "\u001B[92m";
    public static final String YELLOW = "\u001B[93m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        long anzahlStellen = 5;
        long unterGrenze = (long) Math.pow(10, anzahlStellen - 1);
        long oberGrenze = (long) Math.pow(10, anzahlStellen);

        long ergebnis = random.nextLong(unterGrenze, oberGrenze);
        System.out.println(ergebnis);
        long versuche = 1;

        while (true) {
            System.out.print(anzahlStellen + "-stellige Zahl eingeben: ");
            int spielerGuess = scanner.nextInt();

            if (spielerGuess < unterGrenze || spielerGuess >= oberGrenze) {
                System.out.println("Fehler: Die Zahl muss genau " + anzahlStellen + " Ziffern haben!");
                continue;
            }

            for (int stelle = 1; stelle <= anzahlStellen; stelle++) {
                int match = 0;
                long kleinererZehner = (long) Math.pow(10, anzahlStellen - stelle);
                long jetztStelle = (spielerGuess / kleinererZehner) % 10;

                int prevDuplicates = 0;

                for (int selbstStelle = 0; selbstStelle < stelle; selbstStelle++) {
                    long prevKleinererZehner = (long) Math.pow(10, anzahlStellen - selbstStelle);
                    long prevStelle = (spielerGuess / prevKleinererZehner) % 10;
                    if (prevStelle == jetztStelle) {
                        prevDuplicates++;
                    }
                }


                for (int ergebnisStelle = 1; ergebnisStelle <= anzahlStellen; ergebnisStelle++) {
                    long kleinerZehnerErgebnis = (long) Math.pow(10, anzahlStellen - ergebnisStelle);
                    long jetztStelleErgebnis = (ergebnis / kleinerZehnerErgebnis) % 10;
                    long jetztStelleGuess = (spielerGuess / kleinerZehnerErgebnis) % 10;



                    if (jetztStelle == jetztStelleErgebnis && stelle == ergebnisStelle) {
                        match = 2;
                    } else if (jetztStelle == jetztStelleErgebnis && jetztStelleErgebnis != jetztStelleGuess && prevDuplicates == 0) {
                        match = Math.max(match, 1);
                    } else if (jetztStelle == jetztStelleErgebnis && jetztStelleErgebnis != jetztStelleGuess) {
                        prevDuplicates--;
                    }
                }

                if (match == 0) {
                    System.out.print(jetztStelle + " ");
                } else if (match == 1) {
                    System.out.print(YELLOW + jetztStelle + RESET + " ");
                } else {
                    System.out.print(GREEN + jetztStelle + RESET + " ");
                }

                match = 0;

                Thread.sleep(500);
            }
            System.out.println();
            System.out.println("--------------------------------");
            if (ergebnis == spielerGuess) {
                System.out.println(GREEN + "Jaaa! Richtig geraten. Benötigte Versuche: " + versuche + RESET);
                break;
            }
            versuche++;
        }
    }
}