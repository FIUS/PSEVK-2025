package Day4;

public class Grill {
    String grillmeister;
    int maxWuerstchen;
    int maxHitze;
    int momentaneHitze;
    Grillgut[] wuerstchen;

    public Grill(String grillmeister, int maxWuerstchen, int maxHitze) {
        System.out.println("Es wird ein Grill erstellt.");
        this.grillmeister = grillmeister;
        this.maxWuerstchen = maxWuerstchen;
        this.maxHitze = maxHitze;
        this.momentaneHitze = 0;

        wuerstchen = new Grillgut[maxWuerstchen];
    }

    public void setzeHitze(int zielHitze) {
        if (zielHitze < maxHitze && zielHitze > 0) {
            this.momentaneHitze = zielHitze;
            System.out.println("Hitze auf " + zielHitze + " gesetzt.");
        } else {
            System.out.println("Invalide Hitze");
        }
    }

    public void aufGrillLegen(int stelle, Grillgut grillgut) {
        if (stelle < maxWuerstchen && stelle >= 0 && wuerstchen[stelle] == null) {
            wuerstchen[stelle] = grillgut;
            System.out.println(grillgut.typ + " an Stelle " + stelle + " auf den Grill gelegt.");
        } else {
            System.out.println("Invalides Grillgutplacement :(");
        }
    }

    public void runternehmen(int stelle) {
        if (stelle < maxWuerstchen && stelle >= 0 && wuerstchen[stelle] != null) {
            wuerstchen[stelle].vomGrillNehmen();
        }
    }

    public void grillen(){
        System.out.println("Es wird gegrillt");
        for (int i = 0; i < maxWuerstchen; i++) {
            if (wuerstchen[i] != null) {
                wuerstchen[i].grillen(momentaneHitze);
            }
        }
    }

}
