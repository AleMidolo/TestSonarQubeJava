public class HexConverter {
    /**
     * @param b Un carácter codificado en ASCII de 0-9 a-f A-F
     * @return El valor byte del carácter de 0 a 16.
     */
    public static byte convertHexDigit(byte b) {
        if (b >= '0' && b <= '9') {
            return (byte)(b - '0');
        }
        if (b >= 'a' && b <= 'f') {
            return (byte)(b - 'a' + 10);
        }
        if (b >= 'A' && b <= 'F') {
            return (byte)(b - 'A' + 10);
        }
        throw new IllegalArgumentException("Invalid hex digit: " + (char)b);
    }
}