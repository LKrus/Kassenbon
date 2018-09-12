import java.time.LocalDateTime;

public class Kasse {
    private Warenkorb warenkorb;

    public Kasse(Warenkorb warenkorb) {
        this.warenkorb = warenkorb;
    }

    /**
     * Setzt aktuellen Zeitpunkt, der auf den Kassenbon geschrieben wird
     */
    public Kassenbon schreibeKassenbon(){
        Kassenbon kassenbon =new Kassenbon();
        kassenbon.setZeit(LocalDateTime.now());
        return kassenbon;
    }

    public Warenkorb getWarenkorb() {
        return warenkorb;
    }
}
