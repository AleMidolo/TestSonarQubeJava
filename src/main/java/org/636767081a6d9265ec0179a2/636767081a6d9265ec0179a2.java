public class Utility {

    /** 
     * <p>Metodo di utilità per {@link #createNumber(String)}.</p> <p>Restituisce <code>true</code> se s è <code>null</code>.</p>
     * @param s la String da controllare
     * @return se è composta solo da zeri o <code>null</code>
     */
    private static boolean isAllZeros(String s) {
        if (s == null) {
            return true;
        }
        return s.chars().allMatch(c -> c == '0');
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isAllZeros(null)); // true
        System.out.println(isAllZeros("0000")); // true
        System.out.println(isAllZeros("0001")); // false
        System.out.println(isAllZeros("")); // false
    }
}