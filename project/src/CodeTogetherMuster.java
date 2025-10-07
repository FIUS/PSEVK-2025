public class CodeTogetherMuster {
    public static void main(String[] args) {
        
        int momentaneWurst = 4;
        int letzteWurst = 8;

        while (momentaneWurst <= letzteWurst) {
            System.out.println("Schmeiß Wurst Nr." + momentaneWurst + " auf den Grill");
            momentaneWurst++;
        }
    }
}
