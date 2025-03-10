import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[10]; // Initial capacity
        this.size = 0;
    }

    public ByteVector(int initialCapacity) {
        this.data = new byte[initialCapacity];
        this.size = 0;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = data.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public ByteVector put11(final int byteValue1, final int byteValue2) {
        ensureCapacity(size + 2);
        data[size++] = (byte) byteValue1;
        data[size++] = (byte) byteValue2;
        return this;
    }

    public byte[] toArray() {
        return Arrays.copyOf(data, size);
    }

    public int size() {
        return size;
    }
}