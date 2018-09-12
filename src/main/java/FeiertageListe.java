import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Enthält Liste aller Feiertage des Jahres, berechnet aus {@link FeiertagsberechnungNeu}
 */
public class FeiertageListe {
    public static ArrayList<LocalDate> getArrayListWithFeiertage() {
        ArrayList<LocalDate> feiertage = new ArrayList<>();
        LocalDate heute = LocalDate.now();
        LocalDate ostern = FeiertagsberechnungNeu.osternberechnen(heute);
        LocalDate advent = FeiertagsberechnungNeu.adventberechnen(heute);

        //ostern + ostern abhängige Feiertage
        feiertage.add(ostern);
        feiertage.add(ostern.minusDays(48));
        feiertage.add(ostern.minusDays(47));
        feiertage.add(ostern.minusDays(46));
        feiertage.add(ostern.minusDays(7));
        feiertage.add(ostern.minusDays(3));
        feiertage.add(ostern.minusDays(2));
        feiertage.add(ostern.plusDays(1));
        feiertage.add(ostern.plusDays(39));
        feiertage.add(ostern.plusDays(49));
        feiertage.add(ostern.plusDays(50));
        feiertage.add(ostern.plusDays(60));

        //advent + advent abhängige feiertage
        feiertage.add(advent);
        feiertage.add(advent.minusDays(35));
        feiertage.add(advent.minusDays(32));
        feiertage.add(advent.minusDays(28));
        feiertage.add(advent.minusDays(21));
        feiertage.add(advent.minusDays(14));
        feiertage.add(advent.minusDays(7));

        //feste feiertage
        feiertage.add(LocalDate.of(heute.getYear(), Month.JANUARY, 1));
        feiertage.add(LocalDate.of(heute.getYear(), Month.JANUARY, 6));
        feiertage.add(LocalDate.of(heute.getYear(), Month.FEBRUARY, 14));
        feiertage.add(LocalDate.of(heute.getYear(), Month.MARCH,8));
        feiertage.add(LocalDate.of(heute.getYear(), Month.MAY, 1));
        feiertage.add(LocalDate.of(heute.getYear(), Month.AUGUST, 15));
        feiertage.add(LocalDate.of(heute.getYear(), Month.OCTOBER, 3));
        feiertage.add(LocalDate.of(heute.getYear(), Month.OCTOBER, 31));
        feiertage.add(LocalDate.of(heute.getYear(), Month.NOVEMBER, 1));
        feiertage.add(LocalDate.of(heute.getYear(), Month.NOVEMBER, 2));
        feiertage.add(LocalDate.of(heute.getYear(), Month.NOVEMBER, 11));
        feiertage.add(LocalDate.of(heute.getYear(), Month.DECEMBER, 6));
        feiertage.add(LocalDate.of(heute.getYear(), Month.DECEMBER, 24));
        feiertage.add(LocalDate.of(heute.getYear(), Month.DECEMBER, 25));
        feiertage.add(LocalDate.of(heute.getYear(), Month.DECEMBER, 26));
        feiertage.add(LocalDate.of(heute.getYear(), Month.DECEMBER, 31));

        return feiertage;
    }
}