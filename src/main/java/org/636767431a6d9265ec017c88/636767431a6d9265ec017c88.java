import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LowerBoundsCalculator<K> {

    /** 
     * Encuentra un límite inferior máximo para cada llave.
     * @param keys lista de llaves.
     * @return los límites inferiores de llaves calculados.
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        Map<K, Integer> lowerBoundsMap = new HashMap<>();
        List<Integer> lowerBounds = new ArrayList<>();

        for (K key : keys) {
            // Simulate the computation of a lower bound for each key
            int lowerBound = calculateLowerBound(key);
            lowerBoundsMap.put(key, lowerBound);
            lowerBounds.add(lowerBound);
        }

        return lowerBounds;
    }

    private int calculateLowerBound(K key) {
        // Placeholder for actual lower bound calculation logic
        return key.hashCode() % 100; // Example logic using hashCode
    }

    public static void main(String[] args) {
        LowerBoundsCalculator<String> calculator = new LowerBoundsCalculator<>();
        List<String> keys = List.of("key1", "key2", "key3");
        List<Integer> lowerBounds = calculator.computeLowerBounds(keys);
        System.out.println(lowerBounds);
    }
}