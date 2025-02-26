import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream extends OutputStream {
    @Override
    public void write(byte b[]) throws IOException {
        if (b == null) {
            throw new IOException("Byte array is null");
        }
        // Here you would implement the logic to write the bytes to the output stream.
        // For demonstration purposes, we will just print the length of the byte array.
        System.out.println("Writing " + b.length + " bytes.");
    }

    @Override
    public void write(int b) throws IOException {
        // Implement the method to write a single byte if needed
        throw new UnsupportedOperationException("Single byte write not implemented");
    }
}