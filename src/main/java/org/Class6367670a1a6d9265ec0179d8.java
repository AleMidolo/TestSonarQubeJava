package org;

import java.io.IOException;
import java.io.OutputStream;

public class Class6367670a1a6d9265ec0179d8 extends OutputStream {
    
    @Override 
    public void write(final byte[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array cannot be null");
        }
        // Example implementation: write each byte to the console
        for (byte value : b) {
            System.out.write(value);
        }
    }

    @Override
    public void write(int b) throws IOException {
        System.out.write(b);
    }
}