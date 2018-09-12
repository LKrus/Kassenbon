import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Enthält Methoden, um Feiertage zu berechnen
 */
public class FeiertagsberechnungNeu {

    public static boolean feiertagsrechnung(LocalDate tag){
        boolean istvorfeiertag=false;
        ArrayList<LocalDate> feiertage = FeiertageListe.getArrayListWithFeiertage();
        if (feiertage.contains(tag)){
            istvorfeiertag = true;
        }
        return istvorfeiertag;
    }


    /**
     * Berechnet den 4. Advent, um mit diesem adventsabhängige Feiertage in {@link FeiertageListe} bestimmen zu können
     * @return Datum des Advents
     */
    public static LocalDate adventberechnen(LocalDate heute){
        LocalDate weihnachten = LocalDate.of(heute.getYear(),12,24);
        LocalDate advent = LocalDate.now();
        for(int i =1; i <=7; i++){
            if(weihnachten.minusDays(i).getDayOfWeek() == DayOfWeek.SUNDAY){
                advent = weihnachten.minusDays(i);
            }
        }
        return advent;
    }

    /**
     * Berechnet Ostern, um mit diesem osternabhängige Feiertage in {@link FeiertageListe} bestimmen zu können
     * @return Datum von Ostern
     */
    public static LocalDate osternberechnen(LocalDate heute){
        LocalDate maerz = LocalDate.of(heute.getYear(), 3, 21);
        int jahr = heute.getYear();
        int a = jahr%19;
        int b = jahr%4;
        int c =jahr%7;
        int m = (8*((jahr/100)+13))/25-2;
        int s=(jahr/100)-(jahr/400-2);
        int M = (15+s-m)%30;
        int N = (6+s)%7;
        int d = (M+19*a)%30;
        int D;
        if(d==29){
            D=28;
        }else if(d==28 && a>=11){
            D=27;
        }else{
            D=d;
        }
        int e = (2*b+4*c+6*D+N)%7;

        LocalDate ostern = maerz.plusDays(D+1);

        return ostern;
    }
}
