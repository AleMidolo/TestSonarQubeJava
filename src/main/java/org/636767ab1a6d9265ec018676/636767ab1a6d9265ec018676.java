/**
 * 这是一个十六进制数字吗？
 */
private static boolean isHex(final char c) {
    return (c >= '0' && c <= '9') || 
           (c >= 'a' && c <= 'f') || 
           (c >= 'A' && c <= 'F');
}