package org;

public class Class636766fa1a6d9265ec01779d {
    /** 
     * <p>Controlla se il carattere è un controllo ASCII a 7 bit.</p> 
     * <pre> 
     * Class636766fa1a6d9265ec01779d.isAsciiControl('a')  = false 
     * Class636766fa1a6d9265ec01779d.isAsciiControl('A')  = false 
     * Class636766fa1a6d9265ec01779d.isAsciiControl('3')  = false 
     * Class636766fa1a6d9265ec01779d.isAsciiControl('-')  = false 
     * Class636766fa1a6d9265ec01779d.isAsciiControl('\n') = true 
     * Class636766fa1a6d9265ec01779d.isAsciiControl('&copy;') = false 
     * </pre>
     * @param ch  il carattere da controllare
     * @return true se è minore di 32 o uguale a 127
     */
    public static boolean isAsciiControl(final char ch) {
        return ch < 32 || ch == 127;
    }

    public static void main(String[] args) {
        System.out.println(isAsciiControl('a'));  // false
        System.out.println(isAsciiControl('A'));  // false
        System.out.println(isAsciiControl('3'));  // false
        System.out.println(isAsciiControl('-'));  // false
        System.out.println(isAsciiControl('\n')); // true
        System.out.println(isAsciiControl('\u00A9')); // false
    }
}