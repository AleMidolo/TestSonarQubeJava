import java.io.IOException;
import java.io.OutputStream;
import com.google.protobuf.Schema;
import com.google.protobuf.LinkedBuffer;

public class MessageSerializer {

    /** 
     * Serializes the  {@code message}, prefixed with its length, into an  {@link OutputStream}.
     * @return the size of the message
     */
    public static <T> int writeDelimitedTo(OutputStream out, T message, Schema<T> schema, LinkedBuffer buffer) throws IOException {
        // Serialize the message to a byte array
        byte[] messageBytes = schema.encode(message, buffer);
        
        // Get the length of the message
        int length = messageBytes.length;
        
        // Write the length as a prefix
        out.write(intToByteArray(length));
        
        // Write the message bytes
        out.write(messageBytes);
        
        // Return the size of the message
        return length;
    }

    // Helper method to convert an integer to a byte array
    private static byte[] intToByteArray(int value) {
        return new byte[] {
            (byte) (value >> 24),
            (byte) (value >> 16),
            (byte) (value >> 8),
            (byte) value
        };
    }
}