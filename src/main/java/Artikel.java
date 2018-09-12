/**
 * Erstellt Artikel aus Namen und Preis, die im {@link Regal} festgelegt werden
 */
public class Artikel {
    private String name;
    private double preis;

    Artikel(String name, double preis){
        this.name= name;
        this.preis =preis;
    }

    public String getName() {
        return name;
    }

    public double getPreis() {
        return preis;
    }
}
