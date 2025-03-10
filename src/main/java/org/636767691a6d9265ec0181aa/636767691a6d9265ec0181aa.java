import java.util.Arrays;

public class HashCodeUtil {

    /**
     * Return a hash code based on the contents of the specified array. If <code>array</code> is <code>null</code>, this method returns 0.
     * @param array the long array to obtain a hashcode
     * @return the long array's hashcode, which could be 0 if the array is null.
     */
    public static int nullSafeHashCode(long[] array) {
        if (array == null) {
            return 0;
        }
        return Arrays.hashCode(array);
    }

    public static void main(String[] args) {
        long[] array = {1L, 2L, 3L};
        System.out.println(nullSafeHashCode(array)); // Example usage
    }
}