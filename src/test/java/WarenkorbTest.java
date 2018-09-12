import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WarenkorbTest {

    @Test
    void getFeiertagspreisdifferenz() {
        // vor keinem Feiertag
        double ergebnis = Warenkorb.getFeiertagspreisdifferenz(30, LocalDate.of(2018,3,5));
        assertEquals(0, ergebnis);

        //1 Tag vorm Feiertag
        ergebnis = Warenkorb.getFeiertagspreisdifferenz(30, LocalDate.of(2018,3,7));
        assertEquals(-0.6, ergebnis);

        //2 Tage vor Feiertag
        ergebnis = Warenkorb.getFeiertagspreisdifferenz(30, LocalDate.of(2018,3,6));
        assertEquals(1.2, ergebnis);
    }
}