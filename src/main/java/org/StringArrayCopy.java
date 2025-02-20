package org;

import java.util.Arrays;

public class StringArrayCopy {

    /** 
     * Questo metodo crea una copia dell'array fornito e garantisce che tutte le stringhe nel nuovo array creato contengano solo lettere minuscole. <p> Utilizzare questo metodo per copiare array di stringhe significa che le modifiche all'array src non modificano l'array dst.
     */
    private static String[] copiaStringhe(final String[] src) {
        if (src == null) {
            return null;
        }
        
        String[] dst = new String[src.length];
        for (int i = 0; i < src.length; i++) {
            dst[i] = src[i] != null ? src[i].toLowerCase() : null;
        }
        return dst;
    }

    public static void main(String[] args) {
        String[] original = {"Hello", "World", "JAVA", null, "Programming"};
        String[] copied = copiaStringhe(original);
        
        System.out.println(Arrays.toString(copied)); // Output: [hello, world, java, null, programming]
    }
}