import java.io.IOException;
import java.io.DataInputStream;

public class DataReader {
    private DataInputStream input;

    public DataReader(DataInputStream input) {
        this.input = input;
    }

    /** 
     * Lee el valor de un campo de tipo {@code string} del flujo.
     */
    @Override
    public String readString() throws IOException {
        // Read the string length first
        int length = input.readInt();
        
        // If length is -1, return null (for null strings)
        if (length == -1) {
            return null;
        }
        
        // Create byte array to hold string data
        byte[] bytes = new byte[length];
        
        // Read the bytes
        input.readFully(bytes);
        
        // Convert bytes to string using UTF-8 encoding
        return new String(bytes, "UTF-8");
    }
}