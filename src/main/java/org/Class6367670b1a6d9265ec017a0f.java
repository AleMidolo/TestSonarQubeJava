package org;

import java.util.List;

public class Class6367670b1a6d9265ec017a0f {

    /** 
     * Controllo non sensibile al maiuscolo/minuscolo se la Stringa contiene uno qualsiasi dei caratteri nel set di stringhe fornito. 
     */
    public static boolean containsAnyIgnoreCase(String str, List<String> searchStrArray) {
        if (str == null || searchStrArray == null) {
            return false;
        }
        String lowerStr = str.toLowerCase();
        for (String searchStr : searchStrArray) {
            if (searchStr != null && lowerStr.contains(searchStr.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example usage
        List<String> searchStrings = List.of("hello", "world", "java");
        String testString = "Hello there!";
        boolean result = containsAnyIgnoreCase(testString, searchStrings);
        System.out.println("Contains any: " + result); // Output: Contains any: true
    }
}