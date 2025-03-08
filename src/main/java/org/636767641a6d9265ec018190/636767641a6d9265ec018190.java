import java.util.List;
import java.util.Set;

public class BucketManager {

    /**
     * Sposta tutti i vertici dal bucket con etichetta {@code minLabel} al bucket con etichetta 0. 
     * Pulisce il bucket con etichetta {@code minLabel}. Aggiorna le etichette di conseguenza.
     * @param bucketsByLabel i buckets in cui sono memorizzati i vertici
     * @param labels le etichette dei vertici
     * @param minLabel il valore minimo del bucket non vuoto
     */
    private void reload(List<Set<Integer>> bucketsByLabel, List<Integer> labels, int minLabel) {
        // Get the bucket with the minLabel
        Set<Integer> minLabelBucket = bucketsByLabel.get(minLabel);
        // Get the bucket with label 0
        Set<Integer> zeroLabelBucket = bucketsByLabel.get(0);
        
        // Move all vertices from minLabel bucket to the bucket with label 0
        zeroLabelBucket.addAll(minLabelBucket);
        
        // Clear the minLabel bucket
        minLabelBucket.clear();
        
        // Update labels for the moved vertices
        for (Integer vertex : zeroLabelBucket) {
            labels.set(vertex, 0); // Update the label to 0
        }
    }
}