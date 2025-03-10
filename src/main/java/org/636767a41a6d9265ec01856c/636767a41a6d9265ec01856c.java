import java.nio.charset.StandardCharsets;

public class UTF8SizeCalculator {
    /**
     * निर्दिष्ट {@code index} से शुरू होने वाले utf8 स्ट्रिंग का आकार निर्दिष्ट {@code length} के साथ गणना करता है।
     */
    public static int computeUTF8Size(final CharSequence str, final int index, final int len) {
        if (str == null || index < 0 || len < 0 || index + len > str.length()) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        String substring = str.subSequence(index, index + len).toString();
        byte[] utf8Bytes = substring.getBytes(StandardCharsets.UTF_8);
        return utf8Bytes.length;
    }

    public static void main(String[] args) {
        CharSequence str = "Hello, 世界!";
        int index = 7;
        int len = 2;
        int size = computeUTF8Size(str, index, len);
        System.out.println("UTF-8 size: " + size);
    }
}