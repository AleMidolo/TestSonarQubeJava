package org;

public class Class636766fb1a6d9265ec0177c1 {
    /** 
     * <p>Controlla se il carattere è un carattere alfabetico maiuscolo ASCII a 7 bit.</p> 
     * <pre> 
     * Class636766fb1a6d9265ec0177c1.isAsciiAlphaUpper('a')  = false 
     * Class636766fb1a6d9265ec0177c1.isAsciiAlphaUpper('A')  = true 
     * Class636766fb1a6d9265ec0177c1.isAsciiAlphaUpper('3')  = false 
     * Class636766fb1a6d9265ec0177c1.isAsciiAlphaUpper('-')  = false 
     * Class636766fb1a6d9265ec0177c1.isAsciiAlphaUpper('\n') = false 
     * Class636766fb1a6d9265ec0177c1.isAsciiAlphaUpper('&copy;') = false 
     * </pre>
     * @param ch  il carattere da controllare
     * @return true se compreso tra 65 e 90 inclusi
     */
    public static boolean isAsciiAlphaUpper(final char ch) {
        return ch >= 65 && ch <= 90;
    }

    public static void main(String[] args) {
        System.out.println(isAsciiAlphaUpper('a'));  // false
        System.out.println(isAsciiAlphaUpper('A'));  // true
        System.out.println(isAsciiAlphaUpper('3'));  // false
        System.out.println(isAsciiAlphaUpper('-'));  // false
        System.out.println(isAsciiAlphaUpper('\n')); // false
        System.out.println(isAsciiAlphaUpper('&'));   // false
    }
}