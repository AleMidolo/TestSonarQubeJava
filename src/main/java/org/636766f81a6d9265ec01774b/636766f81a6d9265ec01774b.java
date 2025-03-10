import java.io.IOException;
import java.io.InputStream;

public class ByteReader {
    private InputStream inputStream;
    private byte[] buffer;
    private int bufferPosition;
    private int bufferLength;

    public ByteReader(InputStream inputStream, int bufferSize) {
        this.inputStream = inputStream;
        this.buffer = new byte[bufferSize];
        this.bufferPosition = 0;
        this.bufferLength = 0;
    }

    public byte readByte() throws IOException {
        if (bufferPosition >= bufferLength) {
            fillBuffer();
        }
        if (bufferLength == -1) {
            throw new IOException("No more data available");
        }
        return buffer[bufferPosition++];
    }

    private void fillBuffer() throws IOException {
        bufferLength = inputStream.read(buffer);
        bufferPosition = 0;
    }
}