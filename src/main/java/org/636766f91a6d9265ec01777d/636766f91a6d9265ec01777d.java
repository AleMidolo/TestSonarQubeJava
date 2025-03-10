public class HexDigitConverter {
    /**
     * @param b 一个 ASCII 编码的字符，范围为 0-9、a-f、A-F
     * @return 字符的字节值，范围为 0-16。
     */
    public static byte convertHexDigit(byte b) {
        if (b >= '0' && b <= '9') {
            return (byte) (b - '0');
        } else if (b >= 'a' && b <= 'f') {
            return (byte) (b - 'a' + 10);
        } else if (b >= 'A' && b <= 'F') {
            return (byte) (b - 'A' + 10);
        } else {
            throw new IllegalArgumentException("Invalid hex digit: " + (char) b);
        }
    }

    public static void main(String[] args) {
        byte b1 = 'A';
        byte b2 = 'f';
        byte b3 = '5';
        
        System.out.println(convertHexDigit(b1)); // 输出: 10
        System.out.println(convertHexDigit(b2)); // 输出: 15
        System.out.println(convertHexDigit(b3)); // 输出: 5
    }
}