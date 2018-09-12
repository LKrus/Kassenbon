import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KassenbonTest {

    @Test
    void zeichneAusgabe() {
        String ergebnis = Kassenbon.zeichneAusgabe("Tralala", "Hihihi", "-");
        assertEquals("Tralala                  -Hihihi", ergebnis);
    }

    @Test
    void zeichneAusgabe2(){
        String ergebnis = Kassenbon.zeichneAusgabe2("Trööt", "Bla");
        assertEquals("Trööt * Bla                      ", ergebnis);
    }
}