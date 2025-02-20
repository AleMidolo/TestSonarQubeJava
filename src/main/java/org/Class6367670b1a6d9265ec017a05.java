package org;

public class Class6367670b1a6d9265ec017a05 {
    private static final String[] CACHE = new String[128];

    static {
        for (int i = 0; i < CACHE.length; i++) {
            CACHE[i] = String.valueOf((char) i);
        }
    }

    /**
     * <p>Converte il carattere in una Stringa che contiene il singolo carattere.</p> 
     * <p>Per i caratteri ASCII a 7 bit, utilizza una cache che restituirà lo stesso oggetto String ogni volta.</p> 
     * <pre> Class6367670b1a6d9265ec017a05.toString(' ')  = " " Class6367670b1a6d9265ec017a05.toString('A')  = "A" </pre>
     * @param ch  il carattere da convertire
     * @return una Stringa contenente il carattere specificato
     */
    public static String toString(final char ch) {
        if (ch >= 0 && ch < CACHE.length) {
            return CACHE[ch];
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(Class6367670b1a6d9265ec017a05.toString(' ')); // Output: " "
        System.out.println(Class6367670b1a6d9265ec017a05.toString('A')); // Output: "A"
        System.out.println(Class6367670b1a6d9265ec017a05.toString('Z')); // Output: "Z"
        System.out.println(Class6367670b1a6d9265ec017a05.toString('ñ')); // Output: "ñ"
    }
}