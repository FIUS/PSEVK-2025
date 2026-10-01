import java.util.LinkedList;

public class BaumMain {
    public static void main(String[] args) {
        BinaerBaum baum = new BinaerBaum();
        baum.einfuegenZufaellig(10);
        baum.einfuegenZufaellig(20);
        baum.einfuegenZufaellig(30);
        baum.einfuegenZufaellig(40);
        baum.einfuegenZufaellig(50);
        baum.einfuegenZufaellig(60);


        System.out.println("Originalbaum:");
        baum.baumAusgeben();

        LinkedList<Integer> liste = baum.baumZuListe();
        System.out.println("\nBaum als Liste:");
        System.out.println(liste);

        BinaerBaum neuerBaum = new BinaerBaum();
        neuerBaum.listeZuBaum(new LinkedList<>(liste)); // Kopie, da removeFirst verändert die Liste
        System.out.println("\nRekonstruierter Baum:");
        neuerBaum.baumAusgeben();

        System.out.println("\nMaximale Pfadsumme: " + baum.maxPathSum());

    }
}
