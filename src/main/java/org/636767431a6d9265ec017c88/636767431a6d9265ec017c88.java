import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class LowerBoundsCalculator<K extends Comparable<K>> {

    /**
     * 为每个键找到一个最大下界。
     * @param keys 键的列表。
     * @return 计算出的键的下界。
     */
    private List<Integer> computeLowerBounds(List<K> keys) {
        if (keys == null || keys.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> lowerBounds = new ArrayList<>();
        List<K> sortedKeys = new ArrayList<>(keys);
        Collections.sort(sortedKeys);

        for (K key : keys) {
            int index = Collections.binarySearch(sortedKeys, key);
            if (index < 0) {
                // If the key is not found, binarySearch returns (-(insertion point) - 1)
                index = -index - 1;
            }
            lowerBounds.add(index);
        }

        return lowerBounds;
    }
}