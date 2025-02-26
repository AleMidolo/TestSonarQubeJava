import java.util.HashMap;
import java.util.Map;

public class Accumulatore {
    private Map<String, Long> mappa;

    public Accumulatore() {
        mappa = new HashMap<>();
    }

    /** 
     * Accumula il valore con il valore esistente nella stessa chiave fornita.
     */
    public void accumulazioneValore(String chiave, Long valore) {
        mappa.put(chiave, mappa.getOrDefault(chiave, 0L) + valore);
    }

    public Long getValore(String chiave) {
        return mappa.getOrDefault(chiave, 0L);
    }

    public static void main(String[] args) {
        Accumulatore accumulatore = new Accumulatore();
        accumulatore.accumulazioneValore("chiave1", 10L);
        accumulatore.accumulazioneValore("chiave1", 5L);
        System.out.println("Valore accumulato per chiave1: " + accumulatore.getValore("chiave1")); // Output: 15
    }
}