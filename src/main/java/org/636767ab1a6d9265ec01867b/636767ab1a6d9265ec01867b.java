import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class UTF8Writer {

    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || session == null || lb == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        byte[] bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        lb.writeBytes(bytes);
        return lb;
    }

    public static class LinkedBuffer {
        private final LinkedList<byte[]> buffers = new LinkedList<>();

        public void writeBytes(byte[] bytes) {
            buffers.add(bytes);
        }

        // Additional methods for LinkedBuffer can be added here
    }

    public static class WriteSession {
        // Implementation of WriteSession can be added here
    }

    public static void main(String[] args) {
        // Example usage
        WriteSession session = new WriteSession();
        LinkedBuffer lb = new LinkedBuffer();
        writeUTF8("Hello, World!", session, lb);
    }
}