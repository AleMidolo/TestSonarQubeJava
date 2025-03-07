import java.nio.charset.StandardCharsets;
import java.nio.ByteBuffer;

public class UTF8Writer {

    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || session == null || lb == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        ByteBuffer buffer = ByteBuffer.wrap(utf8Bytes);

        while (buffer.hasRemaining()) {
            if (lb.remaining() == 0) {
                lb = session.allocateNewBuffer();
            }
            lb.put(buffer.get());
        }

        return lb;
    }
}

class LinkedBuffer {
    private byte[] buffer;
    private int position;

    public LinkedBuffer(int capacity) {
        this.buffer = new byte[capacity];
        this.position = 0;
    }

    public void put(byte b) {
        if (position >= buffer.length) {
            throw new IndexOutOfBoundsException("Buffer overflow");
        }
        buffer[position++] = b;
    }

    public int remaining() {
        return buffer.length - position;
    }
}

class WriteSession {
    public LinkedBuffer allocateNewBuffer() {
        return new LinkedBuffer(1024); // Default buffer size
    }
}