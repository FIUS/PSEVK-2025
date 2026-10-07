public class Grillgut {
    String typ; // Der Name des Grillguts
    int minDurchheit; // Die mindeste Durchheit die benötigt ist um gut durch zu sein
    int maxDurchheit; // Die höchste Durchheit die möglich ist bevor ein Grillgut verbrennt
    int durchheit; // Die momentane Durchheit
    int hitzetoleranz; // Die höchstmögliche Hitze die ein Grillgut auf einmal ertragen kann, wenn diese überschritten wird, dann ist das Grillgut sofort verbrannt
    boolean verbrannt; // Der Verbranntheitszustand des Grillguts

    public Grillgut(String typ, int minDurchheit, int maxDurchheit, int hitzetoleranz) {
        /**
         * Initialisiert alle Werte
        */
        this.typ = typ;
        this.minDurchheit = minDurchheit;
        this.maxDurchheit = maxDurchheit;
        this.hitzetoleranz = hitzetoleranz;
        verbrannt = false;
        durchheit = 0;
    }

    public void grillen(int hitze) {
        /**
         * Addiert die gegebene Hitze zur momentanen Durchheit und prüft ob das Grillgut verbrannt ist (ob durch Überschreitung der Maxdurchheit oder wegen der Hitzetoleranz).
        */
        if (hitze >= 0) {
            durchheit += hitze;

            if (durchheit > maxDurchheit) {
                verbrannt = true;
            }
            if (hitze > hitzetoleranz) {
                verbrannt = true;
            }
        }
    }

    public void vomGrillNehmen() {
        /**
         * Gibt aus wie durch das Grillgut ist.
        */
        if (verbrannt || durchheit > maxDurchheit) {
            System.out.println(typ + " ist verbrannt :(");
        } else if (durchheit < minDurchheit) {
            System.out.prdintln(typ + " ist roh :(");
        } else {
            System.out.println(typ + " ist gut :)");
        }
    }
}
