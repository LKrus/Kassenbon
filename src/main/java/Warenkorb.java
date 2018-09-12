import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Warenkorb, erbt von {@link ArrayList} mit dem Generic {@link WarenkorbElement}
 */
public class Warenkorb extends ArrayList<WarenkorbElement> {
    /**
     * Berechnet die Summe der Preise aller enthaltenen Elemente und zieht ggf Rabatte ab
     * @return summe
     */
    public  double getSumme (){    //so nicht testbar?
        double summe=0;
        for(WarenkorbElement element : this ){
            summe+= element.getGesamtPreis() - element.getPreisDifferenz();
        }
        summe = summe - getFeiertagspreisdifferenz(summe, LocalDate.now());

        return summe;
    }

    /**
     * Berechnet Differenz der Summe mit und ohne Feiertagsrabatt
     * @param summe von der der Rabatt abgezogen wird
     * @param tag mit dem ermittelt wird, ob Feiertagsrabatt gilt
     * @return feiertagspreisdifferenz
     */
    public static double getFeiertagspreisdifferenz(double summe, LocalDate tag){

        double feiertagspreisdifferenz=0;

        if(FeiertagsberechnungNeu.feiertagsrechnung(tag.plusDays(1))){
         feiertagspreisdifferenz = summe * (-0.02);
        }else if(FeiertagsberechnungNeu.feiertagsrechnung(tag.plusDays(2))){
            feiertagspreisdifferenz = summe * 0.04;
        }

        return  feiertagspreisdifferenz;
    }
}