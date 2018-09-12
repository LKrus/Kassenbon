import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Enthält Methoden, um Kassenbon auf die Konsole zu zeichnen
 */
public class Kassenbon {
    private LocalDateTime zeit;

    /**
     * Ruft Methoden auf
     * @param kasse um die an Methodenaufrufe zu übergeben können
     */
    public void zeichneKassenbon(Kasse kasse) {
        zeichneKopf();
        zeichneKoerper(kasse);
        zeichneFuss(kasse);
    }

    /**
     * Setzt Zeit des Kassenbons
     * @param zeit die zu druckende Zeit
     */
    public void setZeit(LocalDateTime zeit) {
        this.zeit = zeit;
    }

    /**
     * Zeichnet Kopfleiste des Kassenbons
     */
    public void zeichneKopf() {
        System.out.println("------------------------------------\n|          " +
                 "Mein Einkauf            |\n|                                  |\n|     " + zeit + "     " +
                " |\n|----------------------------------|\n|                              EUR |");
    }

    /**
     * Zeichnet Körper des Kassenbons: Artikelnamen, Mengen, Preise und ggf Mengenrabatte
     * @param kasse da über die Warenkorb und -Element aufgerufen wird
     */
    public void zeichneKoerper(Kasse kasse) {
        DecimalFormat df2 = new DecimalFormat("0.00");
        for (WarenkorbElement warenkorbElement : kasse.getWarenkorb()) {
            System.out.println("| " + zeichneAusgabe(warenkorbElement.getArtikel().getName(), df2.format((warenkorbElement.getGesamtPreis())), " ")+" |");

            System.out.println("| " +zeichneAusgabe2(Double.toString(warenkorbElement.getMenge()), Double.toString(warenkorbElement.getArtikel().getPreis())) +"|");

            if(warenkorbElement.getPreisDifferenz() !=0){
                System.out.println("| "+zeichneAusgabe("Mengenrabatt:  ", df2.format(warenkorbElement.getPreisDifferenz()), "-")+" |");
            }
        }
    }

    /**
     * Zeichnet Fuß des Kassenbons: ggf Abgezogener Teiertagsrabatt + Summe
     * @param kasse da über die Warenkorb und -Element aufgerufen wird
     */
    public void zeichneFuss(Kasse kasse) {
         DecimalFormat df2 = new DecimalFormat("0.00");
        if(Warenkorb.getFeiertagspreisdifferenz(kasse.getWarenkorb().getSumme(), LocalDate.now())!=0){
            System.out.println("| "+ zeichneAusgabe("Wegen Feiertag: ", String.valueOf(Warenkorb.getFeiertagspreisdifferenz(kasse.getWarenkorb().getSumme(), LocalDate.now())), "-")+" |");
        }
        System.out.println("| " + zeichneAusgabe("Summe: ", (df2.format(kasse.getWarenkorb().getSumme())), " ")+" |");
        System.out.println("------------------------------------");
    }


    /**
     * Berechnet die Leerzeichen und gibt die Zeile aus, von zeichneKörper und zeichneFuß aufgerufen
     * @param string Name des Artikels Oder Mengenrabatt Oder Summe
     * @param string2 Gesammtpreis des Artikels Oder Mengenrabattdifferenz Oder Summe
     * @param zeichen leer Oder ggf ein -
     * @return ausgabe die ausgegeben wird
     */
    public static String zeichneAusgabe(String string, String string2, String zeichen){
        String ausgabe ="";

        int anzahl = 31 - string.length() - string2.length();

        for(int i =0; i <anzahl; i++){
            ausgabe += " ";
        }
        ausgabe = string + ausgabe + zeichen + string2;
        return ausgabe;
    }

    /**
     * Berechnet Leerzeichen und gibt Zeile aus, von zeichneKörper aufgerufen
     * @param string Menge des Artikels
     * @param string2 Preis des Artikels
     * @return Ausgabe, die ausgegeben wird
     */
    public static String zeichneAusgabe2(String string, String string2){ //TODO Test erstellen
        String ausgabe ="";

        int anzahl = 30 - string.length() - string2.length();

        for(int i =0; i <anzahl; i++){
            ausgabe += " ";
        }
        ausgabe = string + " * " + string2 + ausgabe;
        return ausgabe;
    }
}