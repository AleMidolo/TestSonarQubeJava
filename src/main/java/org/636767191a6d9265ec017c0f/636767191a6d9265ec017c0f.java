import java.util.Arrays;

public class ByteVector {
    private byte[] buffer;
    private int position;
    private static final int DEFAULT_CAPACITY = 32;

    public ByteVector() {
        buffer = new byte[DEFAULT_CAPACITY];
        position = 0;
    }

    /**
     * Aumenta este vector de bytes para que pueda recibir una cantidad adicional de bytes definida por el argumento 'size'.
     * @param size número de bytes adicionales que este vector de bytes debería poder recibir.
     */
    private void enlarge(final int size) {
        int length = buffer.length;
        int newLength = length;
        
        // Calculate new buffer size needed
        while (position + size > newLength) {
            newLength = newLength * 2;
        }
        
        // Only resize if needed
        if (newLength > length) {
            buffer = Arrays.copyOf(buffer, newLength);
        }
    }
}