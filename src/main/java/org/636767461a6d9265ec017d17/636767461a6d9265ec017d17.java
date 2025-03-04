import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DotUtils {
    /**
     * Unescape a string DOT identifier.
     * @param input the input
     * @return the unescaped output
     */
    private String unescapeId(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Check if string is quoted
        if (input.startsWith("\"") && input.endsWith("\"")) {
            // Remove quotes
            String unquoted = input.substring(1, input.length() - 1);
            
            // Replace escaped quotes
            unquoted = unquoted.replace("\\\"", "\"");
            
            // Replace escaped newlines
            unquoted = unquoted.replace("\\n", "\n");
            
            // Replace escaped tabs
            unquoted = unquoted.replace("\\t", "\t");
            
            // Replace escaped backslashes
            unquoted = unquoted.replace("\\\\", "\\");
            
            return unquoted;
        }

        return input;
    }
}