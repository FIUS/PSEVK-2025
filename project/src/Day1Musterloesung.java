import java.util.Random;
import java.util.Scanner;

public class Day1Musterloesung {
    public static void main(String[] args) {
        // Aufgabe 1
        // 1.1
        // Lösung 1:
        System.out.println("........................\n" +
                "..........@.............\n" +
                "..........@.............\n" +
                "..........@..@..........\n" +
                ".........@..@+..........\n" +
                ".........@..@...........\n" +
                ".........*..............\n" +
                "........................\n" +
                "..@@@@@@@@@@@@@@@@@@....\n" +
                "...@@@@@@@@@@@@@@@@@++..\n" +
                "....@@@@@@@@@@@@@@@.....\n" +
                ".....@@@@@@@@@@@@-......\n" +
                "........@@@@@@..........\n" +
                ".......-@....:@.........\n" +
                "......:@......%@........\n" +
                "...@@@@........@@.......\n" +
                "..@@..@@@@@@@@@@@@......\n" +
                "..@@..@@.........@@.....\n" +
                "...@@@@...........@@....");

        // Lösung 2:
        System.out.println("........................");
        System.out.println("..........@.............");
        System.out.println("..........@.............");
        System.out.println("..........@..@..........");
        System.out.println(".........@..@+..........");
        System.out.println(".........@..@...........");
        System.out.println(".........*..............");
        System.out.println("........................");
        System.out.println("..@@@@@@@@@@@@@@@@@@....");
        System.out.println("...@@@@@@@@@@@@@@@@@++..");
        System.out.println("....@@@@@@@@@@@@@@@.....");
        System.out.println(".....@@@@@@@@@@@@-......");
        System.out.println("........@@@@@@..........");
        System.out.println(".......-@....:@.........");
        System.out.println("......:@......%@........");
        System.out.println("...@@@@........@@.......");
        System.out.println("..@@..@@@@@@@@@@@@......");
        System.out.println("..@@..@@.........@@.....");
        System.out.println("...@@@@...........@@....");

        // 1.2
        int einWert = 0;
        System.out.println(einWert);
        einWert = 7;
        System.out.println(einWert);

        // 1.3
        int zahlEins = 2;
        int zahlZwei = 5;
        System.out.println(zahlEins + zahlZwei);
        System.out.println(zahlEins * zahlZwei);

        // 1.4
        String name = "Paul";
        System.out.println("Hallo " + name);

        // Aufgabe 2
        Scanner derScanner = new Scanner(System.in);

        // 2.1
        System.out.print("Gib eine Zahl ein: ");
        int zahlDrei = derScanner.nextInt();
        System.out.print("Gibt noch eine Zahl ein: ");
        int zahlVier = derScanner.nextInt();
        System.out.println("Die Summe ist: " + (zahlDrei + zahlVier));

        // 2.2
        System.out.print("Gib eine Zahl ein: ");
        int zahlFuenf = derScanner.nextInt();
        System.out.print("Gibt noch eine Zahl ein: ");
        int zahlSechs = derScanner.nextInt();
        System.out.print("Versuche das Ergebnis von " + zahlFuenf + " % " + zahlSechs + "  einzugeben: ");
        int ergebnis = derScanner.nextInt();
        System.out.println("Das richtige Ergebnis von " + zahlFuenf + " % " + zahlSechs + " ist: " + (zahlFuenf % zahlSechs));

        // 2.3
        System.out.print("Gib ein Thema ein: ");
        String thema = derScanner.next();
        System.out.print("Gib ein Verb ein: ");
        String verb = derScanner.next();
        System.out.println("Die " + thema + "-Vorkurs Orgas lieben " + verb + ".");

        // Aufgabe 3
        Scanner sc = new Scanner(System.in);

        // 3.1 + 3.2
        System.out.print("Wie Alt bist du: ");
        int alter = sc.nextInt();
        if (alter >= 18) {
            System.out.println("Herzlich Willkommen zur UNO");


            System.out.print("Bist du ein Ersti (true oder false eingeben)? ");
            boolean ersti = sc.nextBoolean();
            int preis = 8;
            if (ersti) {
                preis = 5;
            }
            System.out.println("Für dich sinds " + preis + " Euro");
        } else {
            System.out.println("Sorry, du darfst noch nicht rein :/");
        }

        // 3.3
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

        // Aufgabe 4
        Random rndGenerator = new Random();
        Scanner sc = new Scanner(System.in);

        //4.1
        // Hier geht es nur darum die erste Idee zu bekommen wie wir Random für unsere Zwecke nutzen können
        // nextInt(3) liefert 0, 1 oder 2. Wir können damit 0 stellvertretend für Schere, 1 für Stein und 2 für Papier nehmen.
        int computerWahl = rndGenerator.nextInt(3);

        // 4.2
            // Eingabe des Spielers
            System.out.println("Wähle 0 (Schere), 1 (Stein) oder 2 (Papier): ");
            int spielerWahl = sc.nextInt();

            // reine Infromationsausgabe
            System.out.println("Computer wählt: " + computerWahl);
            System.out.println("Spieler wählt: " + spielerWahl);

            // Auswertung: Erst Unentschieden prüfen, dann alle 3 Gewinnfälle des Spielers
            if (computerWahl == spielerWahl){
                System.out.println("Unentschieden");
            } else if ((spielerWahl == 0 && computerWahl == 2) ||
                    (spielerWahl == 1 && computerWahl == 0) ||
                    (spielerWahl == 2 && computerWahl == 1)) {
                System.out.println("Spieler hat gewonnen!");
            } else {
                // Wenn es weder Unentschieden ist noch der Spieler gewonnen hat, gewinnt der Computer
                System.out.println("Computer hat gewonnen!");
            }

        // 4.3
        // Wir nutzen die Variablen aus der bisherigen Aufgabe
        // Wir berechnen die Differenz im 3er-Kreis. 
        // Das + 3 verhindert negative Zahlen vor der Modulo-Rechnung:
        int ergebnis = (spielerWahl - computerWahl + 3) % 3;

        if (ergebnis == 0) {
            System.out.println("Unentschieden!");
        } else if (ergebnis == 1) {
            System.out.println("Spieler hat gewonnen!");
        } else {
            System.out.println("Computer hat gewonnen!");
        }

        // 4.4
        // Genau wie eben müssen wir einen Kreis bilden bei dem ein Symbol seine Vorgänger im Kreis schlägt:
        // Beim 3er-Spiel den 1 direkten Vorgänger (Differenz 1).
        // Beim 5er-Spiel die 2 direkten Vorgänger (Differenz 1 und 2).
        //
        // Kreisaufbau:
        // 0: Schere -> schlägt 4 (Echse)  und 3 (Papier)
        // 1: Stein  -> schlägt 0 (Schere) und 4 (Echse)
        // 2: Spock  -> schlägt 1 (Stein)  und 0 (Schere)
        // 3: Papier -> schlägt 2 (Spock)  und 1 (Stein)
        // 4: Echse  -> schlägt 3 (Papier) und 2 (Spock)

        System.out.println("Wähle: 0 (Schere), 1 (Stein), 2 (Spock), 3 (Papier), 4 (Echse): ");
        int spielerWahl = sc.nextInt();
        
        int computerWahl = rndGenerator.nextInt(5);

        System.out.println("Computer wählt: " + computerWahl);
        System.out.println("Spieler wählt:  " + spielerWahl);

        int ergebnis = (spielerWahl - computerWahl + 5) % 5;

        if (ergebnis == 0) {
            System.out.println("Unentschieden!");
        } else if (ergebnis == 1 || ergebnis == 2) {
            System.out.println("Spieler hat gewonnen!");
        } else {
            System.out.println("Computer hat gewonnen!");
        }

        // Highperformer
        
        // Lösung 1:
        //ausgabeZahl = seed * 8387234217L % resultBound;
        // alternativ sehr hohe Primzahl wie 2147483647L nutzen

        // Lösung 2 ist bisschen blöd wegen externen Ressourcen:
        // !Braucht die drei folgenden imports!

        /*
        import java.nio.ByteBuffer;
        import java.security.MessageDigest;
        import java.security.NoSuchAlgorithmException;
        */

        /*
        String seedString = Long.toString(seed);

        try {
            MessageDigest digester = MessageDigest.getInstance("SHA-256");
            byte[] hashedString = digester.digest(seedString.getBytes());
            ByteBuffer bb = ByteBuffer.wrap(hashedString);
            ausgabeZahl = Math.abs(bb.getLong()) % resultBound;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        */
    }
}
