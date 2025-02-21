package org.class636767ab1a6d9265ec018676;

public class HexChecker {
    
    /** 
     * È una cifra esadecimale?
     */
    private static boolean isHex(final char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }

    public static void main(String[] args) {
        // Test the isHex function
        System.out.println(isHex('1')); // true
        System.out.println(isHex('a')); // true
        System.out.println(isHex('G')); // false
        System.out.println(isHex('F')); // true
        System.out.println(isHex('9')); // true
    }
}