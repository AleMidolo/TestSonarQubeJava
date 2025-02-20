package org;

import java.util.Arrays;

public class ByteArrayExpander {
    private byte[] byteArray;
    private int currentSize;

    public ByteArrayExpander(int initialSize) {
        this.byteArray = new byte[initialSize];
        this.currentSize = initialSize;
    }

    /**
     * Espande questo vettore di byte in modo che possa ricevere 'size' byte aggiuntivi.
     * @param size numero di byte aggiuntivi che questo vettore di byte dovrebbe essere in grado di ricevere.
     */
    private void enlarge(final int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than zero.");
        }
        int newSize = currentSize + size;
        byteArray = Arrays.copyOf(byteArray, newSize);
        currentSize = newSize;
    }

    public byte[] getByteArray() {
        return byteArray;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public static void main(String[] args) {
        ByteArrayExpander expander = new ByteArrayExpander(10);
        System.out.println("Current size: " + expander.getCurrentSize());
        expander.enlarge(5);
        System.out.println("New size after enlargement: " + expander.getCurrentSize());
    }
}