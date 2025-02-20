package org;

import java.io.IOException;
import java.io.InputStream;

public class ByteReader {
    private InputStream buffer;
    private int currentByte;
    private boolean endOfStream;

    public ByteReader(InputStream buffer) {
        this.buffer = buffer;
        this.currentByte = -1;
        this.endOfStream = false;
    }

    /** 
     * Legge un byte dal <code>buffer</code> e lo riempie nuovamente se necessario.
     * @return Il prossimo byte dallo stream di input.
     * @throws IOException se non ci sono più dati disponibili.
     */
    public byte readByte() throws IOException {
        if (endOfStream) {
            throw new IOException("No more data available.");
        }

        currentByte = buffer.read();
        if (currentByte == -1) {
            endOfStream = true;
            throw new IOException("No more data available.");
        }

        return (byte) currentByte;
    }
}