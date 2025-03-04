import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayBuilder {
    private ByteArrayOutputStream outputStream;

    public ByteArrayBuilder() {
        outputStream = new ByteArrayOutputStream();
    }

    /**
     * Devuelve un único array de bytes que contiene todos los contenidos escritos en el/los buffer(s).
     */
    public final byte[] toByteArray() {
        try {
            outputStream.flush();
            return outputStream.toByteArray();
        } catch (IOException e) {
            return new byte[0];
        }
    }

    // Other methods to write data to the buffer would go here
    public void write(byte[] data) throws IOException {
        outputStream.write(data);
    }

    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    public void write(byte[] data, int offset, int length) throws IOException {
        outputStream.write(data, offset, length);
    }
}