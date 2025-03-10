import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class StreamReader {

    private InputStream inputStream;

    public StreamReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * Lee el valor de un campo de tipo {@code string} del flujo.
     *
     * @return el valor del campo de tipo {@code string} leído del flujo.
     * @throws IOException si ocurre un error de entrada/salida.
     */
    @Override
    public String readString() throws IOException {
        int length = inputStream.read();
        if (length == -1) {
            throw new IOException("End of stream reached");
        }
        byte[] bytes = new byte[length];
        int bytesRead = inputStream.read(bytes);
        if (bytesRead != length) {
            throw new IOException("Failed to read the expected number of bytes");
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }
}