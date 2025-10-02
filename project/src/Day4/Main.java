package Day4;

public class Main {
    public static void main(String[] args) {
        // Aufgabe 1 Beispielhafte Grillung:

        ArrayGrill derArrayGrill = new ArrayGrill("Felix", 10, 15);

        derArrayGrill.aufGrillLegen(0);
        derArrayGrill.aufGrillLegen(1);
        derArrayGrill.aufGrillLegen(2);
        derArrayGrill.aufGrillLegen(3);
        derArrayGrill.setzeHitze(5);
        derArrayGrill.grillen();
        derArrayGrill.aufGrillLegen(4);
        derArrayGrill.aufGrillLegen(5);
        derArrayGrill.aufGrillLegen(6);
        derArrayGrill.setzeHitze(10);
        derArrayGrill.aufGrillLegen(7);
        derArrayGrill.grillen();
        derArrayGrill.setzeHitze(2);
        derArrayGrill.grillen();
        for (int i = 0; i < 8; i++) {
            derArrayGrill.runternehmen(i);
        }

        // Aufgabe 2 Beispielhafte Grillung:

        Grill derGrill = new Grill("Felix", 10, 15);

        for (int i = 0; i < 3; i++) {
            derGrill.aufGrillLegen(i, new Grillgut("Currywurst", 5, 20, 10));
        }
        derGrill.aufGrillLegen(3, new Grillgut("Steak", 30, 40, 100));
        derGrill.setzeHitze(10);
        derGrill.grillen();
        derGrill.aufGrillLegen(4, new Grillgut("Kartoffel", 3, 6, 2));
        derGrill.grillen();
        for (int i = 0; i < 8; i++) {
            derGrill.runternehmen(i);
        }
    }
}
