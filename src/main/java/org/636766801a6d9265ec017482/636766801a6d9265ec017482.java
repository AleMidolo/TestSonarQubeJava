import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassFileBuffer {
    private byte[] buffer;

    /**
     * Limpia y llena el búfer de este {@code ClassFileBuffer} con el flujo de bytes proporcionado. 
     * El puntero de lectura se restablece al inicio del arreglo de bytes.
     */
    public void readFrom(final InputStream in) throws IOException {
        if (in == null) {
            throw new IllegalArgumentException("InputStream cannot be null");
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] tempBuffer = new byte[1024];
        int bytesRead;

        // Read from the InputStream and write to the ByteArrayOutputStream
        while ((bytesRead = in.read(tempBuffer)) != -1) {
            byteArrayOutputStream.write(tempBuffer, 0, bytesRead);
        }

        // Convert the ByteArrayOutputStream to a byte array
        buffer = byteArrayOutputStream.toByteArray();
    }

    public byte[] getBuffer() {
        return buffer;
    }
}