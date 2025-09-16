public class Day2HighperformerMuster {
    public static void main(String[] args) {
        int numVars = 7;
        int[] vals = new int[numVars];

        boolean erfuellbar = false;
        boolean tautologie = true;
        boolean unerfuellbar = true;

        for (int i = 0; i < Math.pow(2, numVars); i++) {
            String binary = Integer.toBinaryString(i);
            System.out.println(binary);

            for (int j = 0; j < numVars; j++) {
                if (binary.length() <= j) {
                    vals[j] = 0;
                } else {
                    vals[j] = binary.charAt(j) - '0';
                }
            }

            boolean a = vals[0] == 1;
            boolean b = vals[1] == 1;
            boolean c = vals[2] == 1;
            boolean d = vals[3] == 1;
            boolean e = vals[4] == 1;
            boolean f = vals[5] == 1;
            boolean g = vals[6] == 1;

            if ((!(a && b) || a) && (!(c && d) || c) && (e || !e)) {
                erfuellbar = true;
                unerfuellbar = false;
            } else {
                tautologie = false;
            }
        }

        System.out.println(erfuellbar);
        System.out.println(unerfuellbar);
        System.out.println(tautologie);

    }
}
