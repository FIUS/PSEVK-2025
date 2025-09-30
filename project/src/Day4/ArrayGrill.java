package Day4;

public class ArrayGrill {
    String grillmeister;
    int maxWuerstchen;
    int maxHitze;
    int momentaneHitze;
    int[] wuerstchen;

    public ArrayGrill(String grillmeister, int maxWuerstchen, int maxHitze) {
        System.out.println("Es wird ein Grill erstellt.");
        this.grillmeister = grillmeister;
        this.maxWuerstchen = maxWuerstchen;
        this.maxHitze = maxHitze;
        this.momentaneHitze = 0;

        wuerstchen = new int[maxWuerstchen];
        for (int i = 0; i < maxWuerstchen; i++) {
            wuerstchen[i] = -1;
        }
    }

    public void setzeHitze(int zielHitze) {
        if (zielHitze < maxHitze && zielHitze > 0) {
            this.momentaneHitze = zielHitze;
            System.out.println("Hitze auf " + zielHitze + " gesetzt.");
        } else {
            System.out.println("Invalide Hitze");
        }
    }

    public void aufGrillLegen(int stelle) {
        if (stelle < maxWuerstchen && stelle >= 0 && wuerstchen[stelle] == -1) {
            wuerstchen[stelle] = 0;
            System.out.println("Würstchen an Stelle " + stelle + " auf den Grill gelegt.");
        } else {
            System.out.println("Invalides Würstchenplacement :(");
        }
    }

    public void runternehmen(int stelle) {
        if (stelle < maxWuerstchen && stelle >= 0 && wuerstchen[stelle] != -1) {
            if (wuerstchen[stelle] < 10) {
                System.out.println("Das Würstchen ist roh :(");
            } else if (wuerstchen[stelle] >= 10 && wuerstchen[stelle] <= 15) {
                System.out.println("Das Würstchen ist durch :)");
            } else {
                System.out.println("Das Würstchen ist verbrannt :(");
            }
        }
    }

    public void grillen(){
        System.out.println("Es wird gegrillt");
        for (int i = 0; i < maxWuerstchen; i++) {
            if (wuerstchen[i] != -1) {
                wuerstchen[i] = wuerstchen[i] + momentaneHitze;
            }
        }
    }
}
