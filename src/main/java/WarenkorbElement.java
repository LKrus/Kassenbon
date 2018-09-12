import java.text.DecimalFormat;
import java.util.logging.Logger;

/**
 * Warenkorbelement, ist im Warenkorb enthalten, bildet sich aus {@link Artikel} und Menge
 */
public class WarenkorbElement {
    private Artikel artikel;
    private  int menge;

    public WarenkorbElement(Artikel artikel, int menge) {
        this.artikel = artikel;
        this.menge = menge;
    }

    /**
     * Methode berechnet aus Menge und Preis des {@link Artikel}s den GesamtPreis
     * @return Gesamtpreis des Elementes
     * @see Artikel
     * @see Warenkorb
     */
    public double getGesamtPreis(){
        return this.menge * this.artikel.getPreis();
    }


    /**
     * Berechnet Preisdifferenz aus GesamtPreis und Gesamtpreis mit Rabatt
     * @return PreisDifferenz die in getSumme verrrechnet wird
     */
    public  double getPreisDifferenz(){
        if(this.menge >=10){
            return getGesamtPreis() * 0.03;
        }else if(this.menge >= 5){
            return getGesamtPreis() * 0.02;
        }
        return 0;
    }

    public Artikel getArtikel() {

        return artikel;
    }

    public void setArtikel(Artikel artikel) {

        this.artikel = artikel;
    }

    public int getMenge() {

        return menge;
    }

    public void setMenge(int menge) {

        this.menge = menge;
    }
}
