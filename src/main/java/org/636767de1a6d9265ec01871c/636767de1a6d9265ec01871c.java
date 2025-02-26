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

    public Map<String, Long> getMappa() {
        return mappa;
    }

    public static void main(String[] args) {
        Accumulatore accumulatore = new Accumulatore();
        accumulatore.accumulazioneValore("chiave1", 10L);
        accumulatore.accumulazioneValore("chiave1", 5L);
        accumulatore.accumulazioneValore("chiave2", 20L);
        
        System.out.println(accumulatore.getMappa()); // Output: {chiave1=15, chiave2=20}
    }
}