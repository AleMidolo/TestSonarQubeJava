/**
 * È una cifra esadecimale?
 */
private static boolean isHex(final char c) {
    return (c >= '0' && c <= '9') || 
           (c >= 'a' && c <= 'f') || 
           (c >= 'A' && c <= 'F');
}