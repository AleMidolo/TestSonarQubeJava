package org;

public class DigitValueInterpreter {

    /** 
     * Interpreta un carattere come una cifra (in qualsiasi base fino a 36) e restituisce il valore numerico. 
     * Questo è simile a {@code Character.digit()} ma non accettiamo cifre non-ASCII.
     */
    private static int digitValue(final char c) {
        if (c >= '0' && c <= '9') {
            return c - '0'; // Cifre da 0 a 9
        } else if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10; // Cifre da A a Z
        } else if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10; // Cifre da a a z
        } else {
            throw new IllegalArgumentException("Carattere non valido: " + c);
        }
    }

    public static void main(String[] args) {
        // Esempi di utilizzo
        System.out.println(digitValue('0')); // 0
        System.out.println(digitValue('9')); // 9
        System.out.println(digitValue('A')); // 10
        System.out.println(digitValue('Z')); // 35
        System.out.println(digitValue('a')); // 10
        System.out.println(digitValue('z')); // 35
    }
}