package org;

public class Class636766fb1a6d9265ec0177c3 {
    /** 
     * <p>Controlla se il carattere è ASCII a 7 bit.</p> <pre> Class636766fb1a6d9265ec0177c3.isAscii('a')  = true Class636766fb1a6d9265ec0177c3.isAscii('A')  = true Class636766fb1a6d9265ec0177c3.isAscii('3')  = true Class636766fb1a6d9265ec0177c3.isAscii('-')  = true Class636766fb1a6d9265ec0177c3.isAscii('\n') = true Class636766fb1a6d9265ec0177c3.isAscii('&copy;') = false </pre>
     * @param ch  il carattere da controllare
     * @return true se inferiore a 128
     */
    public static boolean isAscii(final char ch) {
        return ch < 128;
    }

    public static void main(String[] args) {
        System.out.println(isAscii('a'));  // true
        System.out.println(isAscii('A'));  // true
        System.out.println(isAscii('3'));  // true
        System.out.println(isAscii('-'));  // true
        System.out.println(isAscii('\n')); // true
        System.out.println(isAscii('©'));  // false
    }
}