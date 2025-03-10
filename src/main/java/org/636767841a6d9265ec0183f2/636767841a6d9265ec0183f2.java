import java.util.Comparator;

public class CustomComparator implements Comparator<Object> {

    /**
     * Compares two objects for order. Returns a negative integer, zero, or a positive integer
     * as the first argument is less than, equal to, or greater than the second.
     *
     * @param aObj1 the first object to be compared.
     * @param aObj2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than,
     *         equal to, or greater than the second.
     * @throws ClassCastException if the arguments' types prevent them from being compared by this comparator.
     */
    @Override
    public int compare(Object aObj1, Object aObj2) {
        if (aObj1 == null && aObj2 == null) {
            return 0;
        } else if (aObj1 == null) {
            return -1;
        } else if (aObj2 == null) {
            return 1;
        }

        if (aObj1 instanceof Comparable && aObj2 instanceof Comparable) {
            return ((Comparable) aObj1).compareTo(aObj2);
        } else {
            throw new ClassCastException("Objects do not implement Comparable");
        }
    }
}