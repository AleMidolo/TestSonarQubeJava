package org.class636766a81a6d9265ec017595;

import java.util.Arrays;

public class ByteVector {
    private byte[] data;
    private int size;

    public ByteVector() {
        this.data = new byte[2]; // inizializza con una dimensione iniziale
        this.size = 0;
    }

    /**
     * Inserisce due byte in questo vettore di byte. Il vettore di byte viene automaticamente ingrandito se necessario.
     * @param byteValue1 un byte.
     * @param byteValue2 un altro byte.
     * @return questo vettore di byte.
     */
    final ByteVector put11(final int byteValue1, final int byteValue2) {
        ensureCapacity(size + 2); // Assicurati che ci sia spazio per due byte
        data[size++] = (byte) byteValue1; // Aggiungi il primo byte
        data[size++] = (byte) byteValue2; // Aggiungi il secondo byte
        return this; // Restituisci il vettore di byte
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, minCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public byte[] getData() {
        return Arrays.copyOf(data, size); // Restituisci una copia del vettore di byte attuale
    }
}