import java.util.UUID;

public class SessionUtil {
    /**
     * Generates a unique session ID.
     * 
     * @return A unique session ID as a String.
     */
    public static String sessionId() {
        return UUID.randomUUID().toString();
    }
}