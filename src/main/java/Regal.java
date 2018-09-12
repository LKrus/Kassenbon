import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Legt Namen und Preise fest, aus denen {@link Artikel}  erstellt werden
 */
public class Regal {

    /**
     * Liest CSV Datei aus, erstellt Artikel, speichert die in ArrayList ab
     * @return artikelliste: ArrayList mit Artikeln
     */
    public static ArrayList<Artikel> getArrayListAusArtikel() {
        ArrayList<Artikel> artikelliste = new ArrayList<>();

        String csvFile = "C:/Mein_Praktikum_Leonie/eclipse-jee-photon-R/workspace/Kassenbon/Files/k.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";


        //csv einlesen
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] artikel = line.split(csvSplitBy);

                //Artikel aus artikel erstellen
                Artikel artikel1 = getArtikel(artikel);

                // Artikel1 in Arraylist speichern
                artikelliste.add(artikel1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
       return artikelliste;
    }

    public static Artikel getArtikel(String[] artikel) {
        return new Artikel(artikel[0], Double.valueOf(artikel[1]));
    }
}
