public class Day2HighperformerMuster {
    public static void main(String[] args) {
        int numVars = 8;

        int wahr = 0;
        int falsch = 0;

        boolean erfuellbar = false;
        boolean tautologie = true;
        boolean unerfuellbar = true;

        for (int i = 0; i < Math.pow(2, numVars); i++) {
            String binary = Integer.toBinaryString(i);
            System.out.println(binary);

            while (binary.length() < numVars) {
                binary = "0" + binary;
            }

            boolean a = binary.charAt(0) == '1';
            boolean b = binary.charAt(1) == '1';
            boolean c = binary.charAt(2) == '1';
            boolean d = binary.charAt(3) == '1';
            boolean e = binary.charAt(4) == '1';
            boolean f = binary.charAt(5) == '1';
            boolean g = binary.charAt(6) == '1';
            boolean h = binary.charAt(7) == '1';

            if (((a && b && !c && !d && !e) || (!a && c && d && !b && !e) || (!b && !c
                    && !d && e && f)) && (!g || h)) {
                wahr++;
                erfuellbar = true;
                unerfuellbar = false;
            } else {
                falsch++;
                tautologie = false;
            }
        }

        System.out.println("Die Formel ist erfüllbar ist: " + erfuellbar);
        System.out.println("Die Formel ist unerfüllbar ist: " + unerfuellbar);
        System.out.println("Die Formel ist eine Tautologie ist: " + tautologie);
        System.out.println("Die Formel wird bei " + wahr + " von " + (int) Math.pow(2, numVars) + " Belegungen wahr");
        System.out.println("Die Wahrscheinlichkeit das die Formel bei einer zufälligen Belegung wahr wird ist " + wahr / Math.pow(2, numVars) * 100 + "%");

    }
}
