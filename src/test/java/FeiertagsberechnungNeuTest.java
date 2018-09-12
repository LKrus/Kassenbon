import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FeiertagsberechnungNeuTest {

    @Test
    void feiertagsrechnung() {
        LocalDate tag = LocalDate.of(2018, 4, 1);
        boolean ergebnis =FeiertagsberechnungNeu.feiertagsrechnung(tag);
        assertTrue(ergebnis);

        LocalDate tag2 = LocalDate.of(2018, 12, 16);
        boolean ergebnis2 =FeiertagsberechnungNeu.feiertagsrechnung(tag2);
        assertTrue(ergebnis2);

        LocalDate tag3 = LocalDate.of(2018, 12, 15);
        boolean ergebnis3 =FeiertagsberechnungNeu.feiertagsrechnung(tag3);
        assertFalse(ergebnis3);
    }


    @Test
    void adventberechnen(){
        LocalDate tag = LocalDate.of(2018,3,6);
        LocalDate ergebnis = FeiertagsberechnungNeu.adventberechnen(tag);
        assertEquals(LocalDate.of(2018,12,23), ergebnis);

        tag = LocalDate.of(2016,3,6);
        ergebnis = FeiertagsberechnungNeu.adventberechnen(tag);
        assertEquals(LocalDate.of(2016,12,18), ergebnis);

        tag = LocalDate.of(2015,3,6);
        ergebnis = FeiertagsberechnungNeu.adventberechnen(tag);
        assertEquals(LocalDate.of(2015,12,20), ergebnis);
    }

    @Test
    void osternberechnen(){
        LocalDate tag = LocalDate.of(2018,1,1);
        LocalDate ergebnis = FeiertagsberechnungNeu.osternberechnen(tag);
        assertEquals(LocalDate.of(2018,4,1),ergebnis);
    }
}