import java.util.Arrays;

public class ByteVector {
    private byte[] buffer;
    private int size;

    public ByteVector() {
        this.buffer = new byte[16]; // Initial capacity
        this.size = 0;
    }

    public ByteVector putInt(final int intValue) {
        ensureCapacity(size + 4); // Ensure space for 4 bytes

        // Write the int value in big-endian order
        buffer[size++] = (byte) (intValue >> 24);
        buffer[size++] = (byte) (intValue >> 16);
        buffer[size++] = (byte) (intValue >> 8);
        buffer[size++] = (byte) intValue;

        return this;
    }

    private void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity > buffer.length) {
            int newCapacity = Math.max(buffer.length * 2, requiredCapacity);
            buffer = Arrays.copyOf(buffer, newCapacity);
        }
    }

    public byte[] toByteArray() {
        return Arrays.copyOf(buffer, size);
    }

    public int size() {
        return size;
    }
}