import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Die Hauptklasse des Programms. Enthält die Main Methode.
 */
public class Shoppen {
    private static Logger log = Logger.getLogger(Shoppen.class.getName());

    static Scanner s = new Scanner(System.in);

    public static ArrayList<Artikel> artikelliste = Regal.getArrayListAusArtikel();

    /**
     * Legt Struktur fest; Controller
     * @param args .
     * @throws Exception für Thread.sleep und FileHandler gebraucht, nicht relevant
     */
    public static void main(String[] args) throws Exception {
        //Logger Ausgaben in Datei speichern
//        FileHandler fh = new FileHandler("
//        log.addHandler(fh);
//        SimpleFormatter formatter = new SimpleFormatter();
//        fh.setFormatter(formatter);

        log.setLevel(Level.INFO);

        log.info("Erstellung des Warenkorbs.");
        Warenkorb warenkorb = new Warenkorb();

        log.info("Artikel werden aus Regal genommen.");
        Thread.sleep(50);
        warenkorbFuellen(warenkorb);

        log.info("Der Warenkorb wird an die Kasse übergeben.");
        Kasse kasse = new Kasse(warenkorb);

        log.info("Erstellung des Kassenbons.");
        Kassenbon kassenbon = kasse.schreibeKassenbon();
        kassenbon.zeichneKassenbon(kasse);
    }


    /**
     * Füllt Warenkorb aus {@link Artikel}
     * @param warenkorb in diesen werden die {@link WarenkorbElement}e gelegt
     * @throws InterruptedException da wir sleep verwenden, nicht relevant, da nur ein Thread
     */
    private static void warenkorbFuellen(Warenkorb warenkorb) throws InterruptedException {
        int artikelwahl;
        System.out.println(" 1 Milka Vollmilch Schokolade \n 2 Milch \n 3 Brot \n 4 Wasser \n 5 Zucker \n 6 Mehl \n " +
                "7 Käse \n 8 Joghurt \n 9 Apfel \n 10 Kartoffel ");
        do {
            Thread.sleep(50);
            System.out.println("Neuer Artikel (bei 0 wird KB ausegeben, bei negativem Artikel wird der Artikel entfernt):");
            artikelwahl = s.nextInt();
            if (artikelwahl > 0 && artikelwahl < 11) {
                Artikel artikel;

                artikel = artikelliste.get(artikelwahl - 1);

                waehleMengeUndLegeInWarenkorb(warenkorb, artikel);
            }
            else if (artikelwahl < 0 && artikelwahl > -11) {
                entferneartikel(artikelwahl, warenkorb);
            } else {
                System.out.println("Keine gültige Aktion");
            }
        } while (artikelwahl != 0);
    }

    /**
     * Überprüft, ob Artikel bereits vorhanden + erstellt ein {@link WarenkorbElement} aus Artikel und Menge
     *
     * @param warenkorb diesem wird das erstellte Element hinzugefügt, bzw die Menge erhöht
     * @param artikel   Artikel, mit dem das {@link WarenkorbElement} gebildet wird
     */
    public static void waehleMengeUndLegeInWarenkorb(Warenkorb warenkorb, Artikel artikel) {
        boolean istinwarenkorb = false;
        WarenkorbElement element;
        System.out.println("Menge: ");
        int menge;
        menge = s.nextInt();
        log.info("Warenkorbelement wird gebildet, bzw bearbeitet.\nDieses wird in den Warenkorb gelegt.");

        for (WarenkorbElement e : warenkorb) {
            if (e.getArtikel().getName().equals(artikel.getName())) {
                istinwarenkorb = true;
                e.setMenge(e.getMenge() + menge);
                break;
            }
        }
        if (!istinwarenkorb) {
            element = new WarenkorbElement(artikel, menge);
            warenkorb.add(element);
        }
    }

    /**
     * Entfernt gewünschten {@link Artikel} aus dem {@link Warenkorb}
     * @param artikelwahl ist negativ: -2 entfernt Artikel Nr 2
     * @param warenkorb aus diesem werden Artikel entfernt
     */
    public static void entferneartikel(int artikelwahl, Warenkorb warenkorb) {
        Artikel artikel = artikelliste.get((artikelwahl + 1) * (-1));
        int index = -1;
        //überprüfen ob artikel  auch wirklich schon vorhanden
        for (WarenkorbElement element : warenkorb) {

            if (element.getArtikel().getName().equals(artikel.getName())) {
                index = warenkorb.indexOf(element);
            } else {
                System.out.println("Der Artikel ist noch nicht / nicht mehr im Warenkorb");
            }
        }
        if (index != -1) {
            log.info("Der letzte Artikel wird entfernt.");
            warenkorb.remove(index);
        }
    }
}