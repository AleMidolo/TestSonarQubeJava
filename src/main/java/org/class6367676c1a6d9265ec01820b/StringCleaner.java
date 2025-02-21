package org.class6367676c1a6d9265ec01820b;

public class StringCleaner {
    
    /** 
     * Elimina qualsiasi carattere in una Stringa data.
     * @param inString la Stringa originale
     * @param charsToDelete un insieme di caratteri da eliminare. Ad esempio, "az\n" eliminerà le 'a', le 'z' e le nuove righe.
     * @return la Stringa risultante
     */
    public static String deleteAny(String inString, String charsToDelete) {
        StringBuilder result = new StringBuilder();
        for (char c : inString.toCharArray()) {
            if (charsToDelete.indexOf(c) == -1) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String original = "Hello World! a z\n";
        String charsToDelete = "az\n";
        String cleaned = deleteAny(original, charsToDelete);
        System.out.println(cleaned); // Output: "Hello World! "
    }
}