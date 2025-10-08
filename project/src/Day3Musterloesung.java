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
