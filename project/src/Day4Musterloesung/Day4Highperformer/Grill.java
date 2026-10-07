import java.util.Random;


public class Grill {
    String grillmeister; // der Name des Grillmeisters
    int maxWuerstchen; // Anzahl der Grillgüter die auf den Grill passen
    int maxHitze; // Die höchstmögliche Hitze des Grills
    int momentaneHitze; // Die Hitze mit die grillen funktion die grillgüter grillt
    Grillgut[] aufDemGrill; // ein array von Grillgütern, die momentan auf dem Grill liegen
    int grillZaehler; // ein Zähler für die Anzahl der Aufrufen der Grillen Funktion

    public Grill(String grillmeister, int maxWuerstchen, int maxHitze) {
        /**
         * Initialisiert alle benötigten Werte
        */
        System.out.println("Es wird ein Grill erstellt.");
        this.grillmeister = grillmeister;
        this.maxWuerstchen = maxWuerstchen;
        this.maxHitze = maxHitze;
        this.momentaneHitze = 0;
        this.grillZaehler = 0;

        aufDemGrill = new Grillgut[maxWuerstchen];
    }

    public void setzeHitze(int zielHitze) {
        /**
         * Setzt die momentane Hitze auf die gegebene Zielhitze, falls diese möglich ist
        */
        if (zielHitze < maxHitze && zielHitze > 0) {
            this.momentaneHitze = zielHitze;
            System.out.println("Hitze auf " + zielHitze + " gesetzt.");
        } else {
            System.out.println(zielHitze + " ist eine invalide Hitze");
        }
    }

    public void aufGrillLegen(int stelle, Grillgut grillgut) {
        /**
         * Nimmt ein Grillgut entgegen und versucht es an der Stelle stelle auf den Grill zu legen, falls dort Platz ist. 
        */
        if (stelle < maxWuerstchen && stelle >= 0 && aufDemGrill[stelle] == null) {
            aufDemGrill[stelle] = grillgut;
            System.out.println(grillgut.typ + " an Stelle " + stelle + " auf den Grill gelegt.");
        } else {
            System.out.println("Invalides Grillgutplacement :(");
        }
    }

    public void runternehmen(int stelle) {
        /**
         * Nimmt das Grillgut vom Grill und ruft die vomGrillNehmen Funktion dessen auf, welche ausgibt ob es gut gegrillt ist.
        */
        if (stelle < maxWuerstchen && stelle >= 0 && aufDemGrill[stelle] != null) {
            aufDemGrill[stelle].vomGrillNehmen();
            aufDemGrill[stelle] = null;
        }
    }

    public void grillen() {
        /**
         * Grillt alle Grillgüter, d.h. addiert die Hitze des Grills zur Durchheit aller Grillgüter. 
         * Zählt zudem den grillZaehler um eins hoch. 
        */
        System.out.println("Es wird gegrillt");
        for (int i = 0; i < maxWuerstchen; i++) {
            if (aufDemGrill[i] != null) {
                aufDemGrill[i].grillen(momentaneHitze);
            }
        }
        grillZaehler++;
    }

    public Grillgut[] zufaelligeGrillgueter() {
        /**
         * Generiert ein Array von 50 - 500 zufälligen Grillgütern, welche alle unbedingt gegrillt werden wollen.
         * Die Mindurchheit ist zwischen 5 und 15
         * Die Maxdurchheit ist zwischen 10 und 30 und ist aber immer größer als die Mindurchheit
         * Die Hitzetoleranz ist zwischen 1 und 10
        */
        Random rnd = new Random();
        int numGrillgueter = rnd.nextInt(451) + 50;
        Grillgut[] grillgueter = new Grillgut[numGrillgueter];

        for (int i = 0; i < numGrillgueter; i++) {
            int minDurchheit = rnd.nextInt(16) + 5;
            int maxDurchheit = rnd.nextInt(31) + 10;
            while (maxDurchheit < minDurchheit) {
                maxDurchheit = rnd.nextInt(31) + 10;
            }
            int hitzeToleranz = rnd.nextInt(11) + 1;

            grillgueter[i] = new Grillgut("Mysterysteak", minDurchheit, maxDurchheit, hitzeToleranz);
        }
        return grillgueter;
    }

    public void suboptimaleGrillerei(Grillgut[] zuGrillen) {
        int anzahlDurch = 0;
        int draufGelegt = 0;
        while (anzahlDurch < zuGrillen.length) {
            int momentaneMaxHitze = maxHitze;

            for (int i = 0; i < aufDemGrill.length; i++) {
                if (aufDemGrill[i] == null && draufGelegt < zuGrillen.length) {
                    aufDemGrill[i] = zuGrillen[draufGelegt];
                    draufGelegt++;
                }
                if (aufDemGrill[i] != null) {
                    momentaneMaxHitze = Math.min(momentaneMaxHitze, aufDemGrill[i].hitzetoleranz);
                    momentaneMaxHitze = Math.min(momentaneMaxHitze, aufDemGrill[i].maxDurchheit - aufDemGrill[i].durchheit);
                }
            }

            setzeHitze(momentaneMaxHitze);
            grillen();

            for (int i = 0; i < aufDemGrill.length; i++) {
                if (aufDemGrill[i] != null && aufDemGrill[i].durchheit <= aufDemGrill[i].maxDurchheit && aufDemGrill[i].durchheit >= aufDemGrill[i].minDurchheit && !aufDemGrill[i].verbrannt) {
                    anzahlDurch++;
                    runternehmen(i);
                }
            }
        }
        System.out.println("Diese Grillung hat für " + zuGrillen.length + " Grillgüter " + grillZaehler + " Grillzyklen gebraucht, ich hoffe, dass war nicht zu lang");
    }

    public boolean alleGutDurch (Grillgut[] zuPruefen) {
        /**
         * Prüft ob alle Grillgüter gut durch sind und nichts verbrannt bzw. Roh ist.
        */
       boolean alleGut = true; 
       for (int i = 0; i < zuPruefen.length; i++) {
            if (verbrannt || durchheit > maxDurchheit || durchheit < minDurchheit) {
                alleGut = false;
            }
       }
       return alleGut;
    }
}
