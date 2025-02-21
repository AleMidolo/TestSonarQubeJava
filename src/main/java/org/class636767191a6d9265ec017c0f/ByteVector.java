package org.class636767191a6d9265ec017c0f;

import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int currentSize;

    public ByteVector(int initialCapacity) {
        data = new byte[initialCapacity];
        currentSize = 0;
    }

    /**
     * Aumenta la taglia di questo vettore di byte in modo che possa ricevere 'size' byte aggiuntivi.
     * @param size numero di byte aggiuntivi che questo vettore di byte dovrebbe essere in grado di ricevere.
     */
    private void enlarge(final int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be non-negative");
        }
        int newSize = currentSize + size;
        if (newSize > data.length) {
            int newCapacity = Math.max(data.length * 2, newSize);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    // Additional methods to manipulate the byte vector can be added here
}