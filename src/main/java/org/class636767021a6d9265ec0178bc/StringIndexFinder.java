package org.class636767021a6d9265ec0178bc;

public class StringIndexFinder {

    /** 
     * Trova il primo indice all'interno di una Stringa, gestendo <code>null</code>. Questo metodo utilizza {@link String#indexOf(String)}. 
     */
    public static int indexOf(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return -1; // Return -1 if either string is null
        }
        return str.indexOf(searchStr); // Use String's indexOf method
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(indexOf("Hello, world!", "world")); // Output: 7
        System.out.println(indexOf("Hello, world!", "Java"));  // Output: -1
        System.out.println(indexOf(null, "world"));             // Output: -1
        System.out.println(indexOf("Hello, world!", null));     // Output: -1
    }
}