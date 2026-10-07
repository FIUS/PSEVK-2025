public class GrillMain {
    public static void main(String[] args) {
        
        // Highperformer Aufgabe
        Grill optimalerGrill = new Grill("Paul", 10, 15);
        Grillgut[] allesGrillzeug = optimalerGrill.zufaelligeGrillgueter();
        optimalerGrill.optimaleGrillerei(allesGrillzeug);
        System.out.println(optimalerGrill.alleGutDurch(allesGrillzeug))
    }
}
