public class SubstringUtil {
    
    /** 
     * Obtiene una subcadena de la cadena especificada evitando excepciones. 
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
        System.out.println(sub("Hello, World!", 7, 12)); // Output: World
        System.out.println(sub("Hello, World!", -1, 5)); // Output: Hello
        System.out.println(sub("Hello, World!", 0, 20)); // Output: Hello, World!
        System.out.println(sub(null, 0, 5)); // Output: null
        System.out.println(sub("Hello", 3, 2)); // Output: ""
    }
}