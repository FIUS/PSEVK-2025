import java.util.LinkedList;
import java.util.Random;


public class BinaerBaum {

    static class Knoten {
        int wert;
        Knoten linkesKind;
        Knoten rechtesKind;

        public Knoten(int wert) {
            this.wert = wert;
            this.linkesKind = null;
            this.rechtesKind = null;
        }
    }

    private Knoten wurzel;
    private Random random = new Random();

    public BinaerBaum() {
        this.wurzel = null;
    }

    public void einfuegenZufaellig(int wert) {
        Knoten neuerKnoten = new Knoten(wert);

        if (wurzel == null) {
            wurzel = neuerKnoten;
            return;
        }

        Knoten aktuell = wurzel;

        while (true) {
            if (random.nextBoolean()) {
                if (aktuell.linkesKind == null) {
                    aktuell.linkesKind = neuerKnoten;
                    return;
                } else {
                    aktuell = aktuell.linkesKind;
                }
            } else {
                if (aktuell.rechtesKind == null) {
                    aktuell.rechtesKind = neuerKnoten;
                    return;
                } else {
                    aktuell = aktuell.rechtesKind;
                }
            }
        }
    }

    private void baumAusgeben(Knoten knoten, String prefix, boolean istLetztesKind) {
        if (knoten == null) return;

        System.out.println(prefix + (!istLetztesKind ? "├── " : "└── ") + knoten.wert);

        if (knoten.linkesKind != null || knoten.rechtesKind != null) {
            String neuerPrefix = prefix + (!istLetztesKind ? "│   " : "    ");

            if (knoten.linkesKind != null && knoten.rechtesKind != null)
                baumAusgeben(knoten.linkesKind, neuerPrefix, false);

            if (knoten.rechtesKind != null)
                baumAusgeben(knoten.rechtesKind, neuerPrefix, true);
        }
    }

    public void baumAusgeben() {
        System.out.println("Aktueller Baum:");
        if (wurzel == null) {
            System.out.println("(leer)");
        } else {
            System.out.println(wurzel.wert);
            if (wurzel.linkesKind != null && wurzel.rechtesKind != null) {}
                baumAusgeben(wurzel.linkesKind, "", false);
            if (wurzel.rechtesKind != null)
                baumAusgeben(wurzel.rechtesKind, "", true);
        }
    }



    public LinkedList<Integer> baumZuListe() {
        LinkedList<Integer> liste = new LinkedList<>();
        baumZuListeRekursiv(wurzel, liste);
        return liste;
    }

    private void baumZuListeRekursiv(Knoten knoten, LinkedList<Integer> liste) {
        if (knoten == null) {
            liste.add(null);
            return;
        }
        liste.add(knoten.wert);
        baumZuListeRekursiv(knoten.linkesKind, liste);
        baumZuListeRekursiv(knoten.rechtesKind, liste);
    }

    public void listeZuBaum(LinkedList<Integer> liste) {
        wurzel = listeZuBaumRekursiv(liste);
    }

    private Knoten listeZuBaumRekursiv(LinkedList<Integer> liste) {
        if (liste.isEmpty()) return null;

        Integer wert = liste.removeFirst();
        if (wert == null) return null;

        Knoten knoten = new Knoten(wert);
        knoten.linkesKind = listeZuBaumRekursiv(liste);
        knoten.rechtesKind = listeZuBaumRekursiv(liste);
        return knoten;
    }

    public int maxPathSum() {
        return maxPathSumRekursiv(wurzel);
    }

    private int maxPathSumRekursiv(Knoten knoten) {
        if (knoten == null) return Integer.MIN_VALUE;
        if (knoten.linkesKind == null && knoten.rechtesKind == null)
            return knoten.wert;

        int maxLinks = maxPathSumRekursiv(knoten.linkesKind);
        int maxRechts = maxPathSumRekursiv(knoten.rechtesKind);

        return knoten.wert + Math.max(maxLinks, maxRechts);
    }

}
