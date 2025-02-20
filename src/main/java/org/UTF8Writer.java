package org;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class UTF8Writer {

    /** 
     * Scrive i byte codificati in utf8 dalla stringa nel {@link LinkedBuffer}.
     */
    public static LinkedBuffer writeUTF8(final CharSequence str, final WriteSession session, final LinkedBuffer lb) {
        if (str == null || lb == null) {
            throw new IllegalArgumentException("Input string and LinkedBuffer cannot be null");
        }

        byte[] utf8Bytes = str.toString().getBytes(StandardCharsets.UTF_8);
        lb.write(utf8Bytes);
        return lb;
    }
}

class LinkedBuffer {
    private LinkedList<byte[]> buffer = new LinkedList<>();

    public void write(byte[] bytes) {
        buffer.add(bytes);
    }

    public LinkedList<byte[]> getBuffer() {
        return buffer;
    }
}

class WriteSession {
    // Implementation of WriteSession can be added here
}