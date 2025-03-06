import java.io.DataInput;
import java.io.IOException;

public class MyReader {
    private DataInput input;

    public MyReader(DataInput input) {
        this.input = input;
    }

    /**
     * Leggi un valore di campo {@code string} dallo stream.
     */
    @Override
    public String readString() throws IOException {
        return input.readUTF();
    }
}