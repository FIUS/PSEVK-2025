import java.util.Random;

public class Day3Musterloesung {
    public static void main(String[] args) {
        // Aufgabe 1

        // 1.1
        ankuendigung();

        // 1.2
        System.out.println(ankuendigungRueckgabe());

        // 1.3
        namensAnkuendigung("Melanie");

        // 1.4
        System.out.println(addierer(3, 5));

        // 1.5
        System.out.println(multiplizierer(3, 5));

        // 1.6
        System.out.println(fakultaet(5));

        // Aufgabe 2
        // 2.1
            int[] einArray = new int[5];
            einArray[0] = 1;
            einArray[1] = 2;
            einArray[2] = 3;
            einArray[3] = 4;
            einArray[4] = 5;
            System.out.println(einArray);
        
        // 2.2
            arrayPrint(einArray);

        // 2.3
            findMax(einArray);

        // 2.4  
            arrayPrint(fibonacci(10));


        // Aufgabe 3
        // 3.1
            int[][] ein2DArray = new int[3][3];
            ein2DArray[0][0] = 1;
            ein2DArray[1][1] = 2;
            ein2DArray[2][2] = 3;
            arrayPrint2D(ein2DArray);

        // 3.2
            arrayPrint2D(diagonalesBandEinfach(6));
        
        // 3.3
            arrayPrint2D(diagonalesBandBreit(6));
            //optional: 3.3 Codeanhang 1,2,3
            arrayPrint2D(kariert(6));
            arrayPrint2D(diamant(7));
            arrayPrint2D(diamanten(10));

        // Aufgabe 4
        // 4.1
            Scanner scanner = new Scanner(System.in);
            String wort = scanner.nextLine();
            char[] wortArray = wort.toCharArray();
        
        // 4.4
            System.out.println(istPalindrom(wortArray));



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
            ergebnis = multiplizierer(ergebnis, i);
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
     public static void findMax(int[] einArray) {
        int max = einArray[0];
        for (int i = 1; i < einArray.length; i++) {
            if (einArray[i] > max) {
                max = einArray[i];
            }
        }
        System.out.println(max);
    }

    // 2.4
    public static int[] fibonacci(int n) {
        if (n <= 0) return new int[0];

        int[] fib = new int[n];
        fib[0] = 0;
        if (n > 1) {
            fib[1] = 1;
        }

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib;
    }


// Aufgabe 3 neu 2D Arrays

    // 3.1
    public static void arrayPrint2D(int[][] einArray) {
        for (int i = 0; i < einArray.length; i++) {
            arrayPrint(einArray[i]);
        }
    }

    // 3.2
    public static int[][] diagonalesBandEinfach(int seitenlaenge) {
        int[][] matrix = new int[seitenlaenge][seitenlaenge];

        for (int i = 0; i < seitenlaenge; i++) {
            for (int j = 0; j < seitenlaenge; j++) {
                if (j == i) {
                    matrix[i][j] = 0;
                }else {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }

    // 3.3

    public static int[][] diagonalesBandBreit(int seitenlaenge) {
        int[][] matrix = new int[seitenlaenge][seitenlaenge];

        for (int i = 0; i < seitenlaenge; i++) {
            for (int j = 0; j < seitenlaenge; j++) {
                if (j >= i - 2 && j <= i + 2) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }

    // 3.3 Codeanhang 1
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

    // 3.3 Codeanhang 2
    public static int[][] diamant(int seitenlaenge) {
        int[][] matrix = new int[seitenlaenge][seitenlaenge];
        int mitte = seitenlaenge / 2;

        for (int i = 0; i < seitenlaenge; i++) {
            for (int j = 0; j < seitenlaenge; j++) {
                matrix[i][j] = 1;

                int abstandI = mitte - i;
                if (abstandI < 0) {
                    abstandI = abstandI * -1; 
                }
                
                int abstandJ = mitte - j;
                if (abstandJ < 0) {
                    abstandJ = abstandJ * -1; 
                }
                
                if (abstandI + abstandJ <= mitte) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    // 3.3 Codeanhang 3
    public static int[][] diamanten(int seitenlaenge) {
        int[][] matrix = new int[seitenlaenge][seitenlaenge];
        int mitte = 2;

        for (int i = 0; i < seitenlaenge; i++) {
            for (int j = 0; j < seitenlaenge; j++) {
                matrix[i][j] = 1;
                
                int zeileImBlock = i % 5;
                int spalteImBlock = j % 5;
                
                int abstandI = mitte - zeileImBlock;
                if (abstandI < 0) {
                    abstandI = abstandI * -1;
                }
                
                int abstandJ = mitte - spalteImBlock;
                if (abstandJ < 0) {
                    abstandJ = abstandJ * -1;
                }
                
                if (abstandI + abstandJ <= mitte) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }
    

// Aufgabe 4
    //4.2
        public static boolean vergleicheRaender(char[] arr) {
        if (arr.length == 0) {
            return false;
        }

        if (arr[0] == arr[arr.length - 1]) {
            return true;
        } else {
            return false;
        }
    }
        // alternative elegante Lösung: return arr[0] == arr[arr.length - 1];
    
    // 4.3
    public static char[] kuerzeArray(char[] arr) {
        char[] gekuerzt = new char[arr.length - 2];

        for (int i = 0; i < gekuerzt.length; i++) {
            gekuerzt[i] = arr[i + 1];
        }
        return gekuerzt;
    }

    // 4.4
    public static boolean istPalindrom(char[] arr) {
        if (arr.length <= 1) {
            return true;
        }

        if (vergleicheRaender(arr)) {
            char[] gekuerztesArray = kuerzeArray(arr);
            return istPalindrom(gekuerztesArray);
        } else {
            return false;
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
