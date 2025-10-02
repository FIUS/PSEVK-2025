package Day4;

public class Grillgut {
    String typ;
    int minDurchheit;
    int maxDurchheit;
    int durchheit;
    int hitzetoleranz;
    boolean verbrannt;

    public Grillgut(String typ, int minDurchheit, int maxDurchheit, int hitzetoleranz) {
        this.typ = typ;
        this.minDurchheit = minDurchheit;
        this.maxDurchheit = maxDurchheit;
        this.hitzetoleranz = hitzetoleranz;
        verbrannt = false;
        durchheit = 0;
    }

    public void grillen(int hitze) {
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
        if (verbrannt) {
            System.out.println(typ + " ist verbrannt :(");
        } else if (durchheit < minDurchheit) {
            System.out.println(typ + " ist roh :(");
        } else {
            System.out.println(typ + " ist gut :)");
        }
    }
}
