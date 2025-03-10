import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int capacity;
    private int size;

    public ByteVector(int initialCapacity) {
        this.data = new byte[initialCapacity];
        this.capacity = initialCapacity;
        this.size = 0;
    }

    private void enlarge(final int size) {
        int newCapacity = capacity + size;
        if (newCapacity < 0) { // Handle overflow
            throw new OutOfMemoryError("Required array size too large");
        }
        data = Arrays.copyOf(data, newCapacity);
        capacity = newCapacity;
    }

    public void add(byte b) {
        if (size == capacity) {
            enlarge(1); // Enlarge by 1 if full
        }
        data[size++] = b;
    }

    public byte[] toArray() {
        return Arrays.copyOf(data, size);
    }
}