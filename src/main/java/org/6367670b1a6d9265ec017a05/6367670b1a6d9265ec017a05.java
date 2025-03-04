package org.apache.commons.lang3;

/**
 * Utility class for working with characters.
 */
public class CharUtils {

    /**
     * The cache of commonly used single character Strings
     */
    private static final String[] CHAR_STRING_CACHE = new String[128];

    static {
        // Initialize cache for ASCII characters
        for (char c = 0; c < CHAR_STRING_CACHE.length; c++) {
            CHAR_STRING_CACHE[c] = String.valueOf(c);
        }
    }

    /**
     * <p>Convierte el carácter en una cadena que contiene un solo carácter.</p>
     * <p>Para caracteres ASCII de 7 bits, utiliza una caché que devolverá el mismo 
     * objeto String cada vez.</p>
     * 
     * <pre>
     * CharUtils.toString(' ')  = " "
     * CharUtils.toString('A')  = "A"
     * </pre>
     *
     * @param ch  el carácter a convertir
     * @return una cadena que contiene el carácter especificado
     */
    public static String toString(final char ch) {
        if (ch < 128) {
            return CHAR_STRING_CACHE[ch];
        }
        return String.valueOf(ch);
    }
}