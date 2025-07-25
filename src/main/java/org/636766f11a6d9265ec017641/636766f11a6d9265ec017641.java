import java.io.IOException;
import java.io.InputStream;

public class CustomInputStream extends InputStream {

    private InputStream inputStream;

    public CustomInputStream(InputStream is) {
        this.inputStream = is;
    }

    /**
     * @see InputStream#available()
     */
    @Override
    public int available() throws IOException {
        return inputStream.available();
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }
}