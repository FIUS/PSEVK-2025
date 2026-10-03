import java.util.Random;

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

        arrayPrint2D(diagonalesBand(13));
        System.out.println();
        arrayPrint2D(kariert(13));
        System.out.println();
        arrayPrint2D(diamant(13));
        System.out.println();
        arrayPrint2D(diamanten(13));
        System.out.println();
        arrayPrint(fibonacci(10));

        // Highperformer

        printZeit(10);

        // Highperformer 2
        int[] zufallArray = new int[100];
        Random rnd = new Random();
        for (int i = 0; i < zufallArray.length; i++) {
            zufallArray[i] = rnd.nextInt(100);
        }

        // Highperformer 3
        arrayPrint(bubbleSort(zufallArray));
        bubbleSortLaufzeit(100);

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
    public static void arrayPrint(int[] einArray) {
        for (int i = 0; i < einArray.length; i++) {
            System.out.print(einArray[i] + " ");
        }
        System.out.println();
    }

    // 2.3
    public static void arrayPrint2D(int[][] einArray) {
        for (int i = 0; i < einArray.length; i++) {
            arrayPrint(einArray[i]);
        }
    }

    // 2.4

    public static int[][] diagonalesBand(int seitenlaenge) {
        int[][] matrix = new int[seitenlaenge][seitenlaenge];

        for (int i = 0; i < seitenlaenge; i++) {
            for (int j = 0; j < seitenlaenge; j++) {
                if (Math.abs(i - j) < 3) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }

    // 2.4 Codeanhang 1
    public static int[][] kariert(int seitenlaenge) {
        int[][] matrix = new int[seitenlaenge][seitenlaenge];
        for (int i = 0; i < seitenlaenge; i++) {
            for (int j = 0; j < seitenlaenge; j++) {
                if ((i + j) % 2 == 0) {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }

    // 2.4 Codeanhang 2
    public static int[][] diamant(int seitenlaenge) {
        int[][] matrix = new int[seitenlaenge][seitenlaenge];
        int mitte = seitenlaenge / 2;

        for (int i = 0; i < seitenlaenge; i++) {
            for (int j = 0; j < seitenlaenge; j++) {
                matrix[i][j] = 1;
                if (Math.abs(mitte - i) + Math.abs(mitte - j) <= mitte) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    // 2.4 Codeanhang 3
    public static int[][] diamanten(int seitenlaenge) {
        int[][] matrix = new int[seitenlaenge][seitenlaenge];
        int mitte = 2;

        for (int i = 0; i < seitenlaenge; i++) {
            for (int j = 0; j < seitenlaenge; j++) {
                matrix[i][j] = 1;
                if (Math.abs(mitte - (i % 5)) + Math.abs(mitte - (j % 5)) <= mitte) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    // 2.5
    public static int[] fibonacci(int n) {
        int[] fib = new int[n];
        fib[0] = 0;
        if (n > 0) {
            fib[1] = 1;
        }

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib;
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
    // Highperformer 1

    public static double printZeit(int anzahlTests) {
        long gesamtZeit = 0;
        for (int i = 0; i < anzahlTests; i++) {
            long start = System.nanoTime();
            System.out.println("test");
            long end = System.nanoTime();
            gesamtZeit += (end - start);
        }
        long durchschnitt = gesamtZeit / anzahlTests;
        System.out.println("Ein Print braucht im " + durchschnitt + " Nanosekunden.");
        return durchschnitt;
    }

    // Highperformer 3

    public static int[] bubbleSort(int[] unsortiert) {
        int n = unsortiert.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (unsortiert[j] > unsortiert[j + 1]) {
                    int temp = unsortiert[j];
                    unsortiert[j] = unsortiert[j + 1];
                    unsortiert[j + 1] = temp;
                }
            }
        }
        return unsortiert;
    }

    public static long bubbleSortLaufzeit(int anzahlTests) {
        long gesamtZeit = 0;
        Random rnd = new Random();

        for (int i = 0; i < anzahlTests; i++) {

            int[] zufallsArray = new int[100];
            for (int j = 0; j < zufallsArray.length; j++) {
                zufallsArray[i] = rnd.nextInt(100);
            }

            long start = System.nanoTime();
            bubbleSort(zufallsArray);
            long end = System.nanoTime();
            gesamtZeit += (end - start);
        }
        long durchschnitt = gesamtZeit / anzahlTests;
        System.out.println("Ein Bubblesort braucht im " + durchschnitt + " Nanosekunden.");
        return durchschnitt;
    }
}
