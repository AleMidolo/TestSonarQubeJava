import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class UpperBoundCalculator<K extends Comparable<K>> {

    /**
     * Trova un limite superiore minimo per ogni chiave.
     * @param keys una lista di chiavi.
     * @return il limite superiore delle chiavi calcolato.
     */
    private List<Integer> computeUpperBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> upperBounds = new ArrayList<>();
        for (K key : keys) {
            int upperBound = findUpperBound(keys, key);
            upperBounds.add(upperBound);
        }

        return upperBounds;
    }

    /**
     * Trova il limite superiore minimo per una singola chiave.
     * @param keys la lista di chiavi.
     * @param key la chiave per cui trovare il limite superiore.
     * @return il limite superiore minimo per la chiave.
     */
    private int findUpperBound(List<K> keys, K key) {
        int low = 0;
        int high = keys.size() - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            K midKey = keys.get(mid);

            if (midKey.compareTo(key) > 0) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result == -1 ? keys.size() : result;
    }

    public static void main(String[] args) {
        UpperBoundCalculator<Integer> calculator = new UpperBoundCalculator<>();
        List<Integer> keys = List.of(1, 3, 5, 7, 9);
        List<Integer> upperBounds = calculator.computeUpperBounds(keys);

        System.out.println("Upper bounds: " + upperBounds);
    }
}