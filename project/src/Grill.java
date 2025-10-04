import java.util.Random;

// Aufgabe 2:

public class Grill {
    String grillmeister;
    int maxWuerstchen;
    int maxHitze;
    int momentaneHitze;
    Grillgut[] aufDemGrill;
    int grillZaehler;

    public Grill(String grillmeister, int maxWuerstchen, int maxHitze) {
        System.out.println("Es wird ein Grill erstellt.");
        this.grillmeister = grillmeister;
        this.maxWuerstchen = maxWuerstchen;
        this.maxHitze = maxHitze;
        this.momentaneHitze = 0;
        this.grillZaehler = 0;

        aufDemGrill = new Grillgut[maxWuerstchen];
    }

    public void setzeHitze(int zielHitze) {
        if (zielHitze < maxHitze && zielHitze > 0) {
            this.momentaneHitze = zielHitze;
            System.out.println("Hitze auf " + zielHitze + " gesetzt.");
        } else {
            System.out.println(zielHitze + " ist eine invalide Hitze");
        }
    }

    public void aufGrillLegen(int stelle, Grillgut grillgut) {
        if (stelle < maxWuerstchen && stelle >= 0 && aufDemGrill[stelle] == null) {
            aufDemGrill[stelle] = grillgut;
            System.out.println(grillgut.typ + " an Stelle " + stelle + " auf den Grill gelegt.");
        } else {
            System.out.println("Invalides Grillgutplacement :(");
        }
    }

    public void runternehmen(int stelle) {
        if (stelle < maxWuerstchen && stelle >= 0 && aufDemGrill[stelle] != null) {
            aufDemGrill[stelle].vomGrillNehmen();
            aufDemGrill[stelle] = null;
        }
    }

    public void grillen() {
        System.out.println("Es wird gegrillt");
        for (int i = 0; i < maxWuerstchen; i++) {
            if (aufDemGrill[i] != null) {
                aufDemGrill[i].grillen(momentaneHitze);
            }
        }
        grillZaehler++;
    }

    // Highperformer Aufgabe 2:
    public Grillgut[] zufaelligeGrillgueter() {
        Random rnd = new Random();
        int numGrillgueter = rnd.nextInt(451) + 50;
        Grillgut[] grillgueter = new Grillgut[numGrillgueter];

        for (int i = 0; i < numGrillgueter; i++) {
            int minDurchheit = rnd.nextInt(16) + 5;
            int maxDurchheit = rnd.nextInt(31) + 10;
            while (maxDurchheit < minDurchheit) {
                maxDurchheit = rnd.nextInt(31) + 10;
            }
            int hitzeToleranz = rnd.nextInt(10) + 1;

            grillgueter[i] = new Grillgut("Mysterysteak", minDurchheit, maxDurchheit, hitzeToleranz);
        }
        return grillgueter;
    }

    // Highperformer Aufgabe 3:
    public void optimaleGrillerei(Grillgut[] zuGrillen) {
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
        System.out.println("Diese Grillung hat für " + zuGrillen.length + " Grillgüter " + grillZaehler + " Grillzyklen gebraucht, ich hoff das war nicht zu lang");
    }
}
