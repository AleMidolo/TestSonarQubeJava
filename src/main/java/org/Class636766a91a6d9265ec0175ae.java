package org;

import java.util.Arrays;

public class Class636766a91a6d9265ec0175ae {
    private byte[] data;
    private int size;

    public Class636766a91a6d9265ec0175ae() {
        this.data = new byte[10]; // Initial capacity
        this.size = 0;
    }

    /** 
     * Inserisce un array di byte in questo vettore di byte. Il vettore di byte viene automaticamente ingrandito se necessario.
     * @param byteArrayValue un array di byte. Può essere {@literal null} per inserire {@code byteLength} byte null in questo vettore di byte.
     * @param byteOffset     indice del primo byte di byteArrayValue che deve essere copiato.
     * @param byteLength     numero di byte di byteArrayValue che devono essere copiati.
     * @return questo vettore di byte.
     */
    public Class636766a91a6d9265ec0175ae putByteArray(final byte[] byteArrayValue, final int byteOffset, final int byteLength) {
        if (byteLength < 0) {
            throw new IllegalArgumentException("byteLength cannot be negative");
        }
        
        if (byteArrayValue == null) {
            byteArrayValue = new byte[byteLength]; // Create an array of null bytes
            byteOffset = 0; // Reset offset since we are using a new array
        } else if (byteOffset < 0 || byteOffset + byteLength > byteArrayValue.length) {
            throw new IndexOutOfBoundsException("Invalid byteOffset or byteLength");
        }

        ensureCapacity(size + byteLength);
        System.arraycopy(byteArrayValue, byteOffset, data, size, byteLength);
        size += byteLength;

        return this;
    }

    private void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, requiredCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    public int size() {
        return size;
    }

    public byte[] toArray() {
        return Arrays.copyOf(data, size);
    }
}