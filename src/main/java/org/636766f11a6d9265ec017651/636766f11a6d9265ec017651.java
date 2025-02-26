public class ArrayUtil {

    private static final Character[] EMPTY_ARRAY = new Character[0];

    /** 
     * <p>Defensive programming technique to change a <code>null</code> reference to an empty one.</p> 
     * <p>This method returns an empty array for a <code>null</code> input array.</p> 
     * <p>As a memory optimizing technique an empty array passed in will be overridden with the empty <code>public static</code> references in this class.</p>
     * @param array  the array to check for <code>null</code> or empty
     * @return the same array, <code>public static</code> empty array if <code>null</code> or empty input
     * @since 2.5
     */
    public static Character[] nullToEmpty(final Character[] array) {
        return (array == null || array.length == 0) ? EMPTY_ARRAY : array;
    }

    public static void main(String[] args) {
        Character[] testArray1 = null;
        Character[] testArray2 = {};
        Character[] testArray3 = {'A', 'B', 'C'};

        System.out.println(nullToEmpty(testArray1).length); // Output: 0
        System.out.println(nullToEmpty(testArray2).length); // Output: 0
        System.out.println(nullToEmpty(testArray3).length); // Output: 3
    }
}