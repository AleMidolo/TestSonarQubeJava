package org.class636766f91a6d9265ec01776e;

import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    @Override
    public void write(final byte b[], final int off, final int len) throws IOException {
        if (b == null) {
            throw new NullPointerException("Byte array is null");
        }
        if (off < 0 || len < 0 || off + len > b.length) {
            throw new IndexOutOfBoundsException("Invalid offset or length");
        }
        // Here you would write the bytes to the output stream
        // For demonstration, we will just print the bytes being written
        for (int i = off; i < off + len; i++) {
            System.out.print((char) b[i]); // Print each byte as a character
        }
        System.out.println(); // New line after writing
    }

    @Override
    public void write(int b) throws IOException {
        // Implementation for writing a single byte
        System.out.print((char) b); // Print the single byte as a character
    }

    public static void main(String[] args) throws IOException {
        CustomOutputStream customOutputStream = new CustomOutputStream();
        byte[] data = "Hello, World!".getBytes();
        customOutputStream.write(data, 0, data.length);
    }
}