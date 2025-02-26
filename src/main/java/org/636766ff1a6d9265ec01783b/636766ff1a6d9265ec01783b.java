public class SubstringUtil {
    
    /** 
     * Ottiene una sottostringa dalla Stringa specificata evitando eccezioni. 
     */
    public static String sub(String str, int start, int end) {
        if (str == null) {
            return null;
        }
        if (start < 0) {
            start = 0;
        }
        if (end > str.length()) {
            end = str.length();
        }
        if (start > end) {
            return "";
        }
        return str.substring(start, end);
    }

    public static void main(String[] args) {
        // Test the sub method
        String testString = "Hello, World!";
        System.out.println(sub(testString, 7, 12)); // Output: World
        System.out.println(sub(testString, -5, 5)); // Output: Hello
        System.out.println(sub(testString, 0, 20)); // Output: Hello, World!
        System.out.println(sub(testString, 5, 3));  // Output: (empty string)
        System.out.println(sub(null, 0, 5));         // Output: null
    }
}