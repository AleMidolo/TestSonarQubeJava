import java.util.HashSet;
import java.util.Set;

/**
 * Efficient way to compute the intersection between two sets
 * @param set1 set $1$
 * @param set2 set $2$
 * @return intersection of set $1$ and $2$
 */
private <V> Set<V> intersection(Set<V> set1, Set<V> set2) {
    Set<V> result = new HashSet<>(set1);
    result.retainAll(set2);
    return result;
}