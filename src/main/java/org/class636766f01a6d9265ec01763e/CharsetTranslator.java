package org.class636766f01a6d9265ec01763e;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharsetTranslator {

    /** 
     * Traduci un nome di set di caratteri standard MIME nell'equivalente Java.
     * @param charset Il nome standard MIME.
     * @return L'equivalente Java per questo nome.
     */
    private static String javaCharset(String charset) {
        if (charset == null || charset.isEmpty()) {
            return null;
        }
        
        try {
            Charset javaCharset = Charset.forName(charset);
            return javaCharset.name();
        } catch (IllegalArgumentException e) {
            return null; // Return null if the charset is not valid
        }
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(javaCharset("UTF-8")); // Output: UTF-8
        System.out.println(javaCharset("ISO-8859-1")); // Output: ISO-8859-1
        System.out.println(javaCharset("invalid-charset")); // Output: null
    }
}