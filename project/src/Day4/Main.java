package Day4;

public class Main {
    public static void main(String[] args) {
        ArrayGrill g = new ArrayGrill("Felix", 10, 15);

        g.aufGrillLegen(0);
        g.aufGrillLegen(1);
        g.aufGrillLegen(2);
        g.aufGrillLegen(3);
        g.setzeHitze(5);
        g.grillen();
        g.aufGrillLegen(4);
        g.aufGrillLegen(5);
        g.aufGrillLegen(6);
        g.setzeHitze(10);
        g.aufGrillLegen(7);
        g.grillen();
        g.setzeHitze(2);
        g.grillen();

        for (int i = 0; i < 8; i++) {
            g.runternehmen(i);
        }
    }
}
