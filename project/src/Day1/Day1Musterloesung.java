package Day1;

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

        // Highperformer
        // 1
        Random random = new Random();
        int zufallszahlEins = random.nextInt(100);
        int zufallszahlZwei = random.nextInt(100);

        System.out.print("Versuche das Ergebnis von  " + zufallszahlEins + " % " + zufallszahlZwei + " einzugeben: ");
        derScanner.nextInt();
        System.out.println("Das richtige Ergebnis von " + zufallszahlEins + " % " + zufallszahlZwei + " ist: " + (zufallszahlEins % zufallszahlZwei));

        // 2
        // Lösung 1:
        //ausgabeZahl = seed * 8387234217L % resultBound;

        // Lösung 2:
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
