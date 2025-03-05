public class StringArrayUtils {
    /**
     * This method creates a copy of the provided array, and ensures that all the strings 
     * in the newly created array contain only lower-case letters. Using this method to copy 
     * string arrays means that changes to the src array do not modify the dst array.
     *
     * @param src The source array to copy from
     * @return A new array containing lowercase copies of the strings
     */
    public static String[] copyToLowerCase(String[] src) {
        if (src == null) {
            return null;
        }
        
        String[] dst = new String[src.length];
        for (int i = 0; i < src.length; i++) {
            if (src[i] != null) {
                dst[i] = src[i].toLowerCase();
            }
        }
        return dst;
    }
}