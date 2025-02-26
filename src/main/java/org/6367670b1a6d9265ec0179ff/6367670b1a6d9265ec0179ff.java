public class ArrayUtil {

    private static final Byte[] EMPTY_BYTE_ARRAY = new Byte[0];

    /** 
     * <p>Defensive programming technique to change a <code>null</code> reference to an empty one.</p> 
     * <p>This method returns an empty array for a <code>null</code> input array.</p> 
     * <p>As a memory optimizing technique an empty array passed in will be overridden with the empty <code>public static</code> references in this class.</p>
     * @param array  the array to check for <code>null</code> or empty
     * @return the same array, <code>public static</code> empty array if <code>null</code> or empty input
     * @since 2.5
     */
    public static Byte[] nullToEmpty(final Byte[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        return array;
    }

    public static void main(String[] args) {
        // Test cases
        Byte[] nullArray = null;
        Byte[] emptyArray = {};
        Byte[] nonEmptyArray = {1, 2, 3};

        System.out.println(nullToEmpty(nullArray).length); // Output: 0
        System.out.println(nullToEmpty(emptyArray).length); // Output: 0
        System.out.println(nullToEmpty(nonEmptyArray).length); // Output: 3
    }
}