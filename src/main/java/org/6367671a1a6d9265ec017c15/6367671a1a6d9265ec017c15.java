import java.util.Arrays;

public class ByteVector {
    private byte[] buffer;
    private int size;

    public ByteVector() {
        this.buffer = new byte[16]; // Initial capacity
        this.size = 0;
    }

    public ByteVector putByteArray(final byte[] byteArrayValue, final int byteOffset, final int byteLength) {
        if (byteLength < 0) {
            throw new IllegalArgumentException("byteLength must be non-negative");
        }
        if (byteOffset < 0) {
            throw new IllegalArgumentException("byteOffset must be non-negative");
        }
        if (byteArrayValue != null && (byteOffset + byteLength) > byteArrayValue.length) {
            throw new IllegalArgumentException("byteOffset + byteLength exceeds byteArrayValue length");
        }

        ensureCapacity(size + byteLength);

        if (byteArrayValue == null) {
            // Fill with null bytes
            Arrays.fill(buffer, size, size + byteLength, (byte) 0);
        } else {
            System.arraycopy(byteArrayValue, byteOffset, buffer, size, byteLength);
        }

        size += byteLength;
        return this;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > buffer.length) {
            int newCapacity = buffer.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
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