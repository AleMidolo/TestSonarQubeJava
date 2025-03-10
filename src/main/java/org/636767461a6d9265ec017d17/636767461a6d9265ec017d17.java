import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnescapeIdExample {

    /**
     * एक स्ट्रिंग DOT पहचानकर्ता को अनएस्केप करें।
     * @param input इनपुट
     * @return अनएस्केप किया गया आउटपुट
     */
    private static String unescapeId(String input) {
        if (input == null) {
            return null;
        }
        
        // Replace escaped dots with actual dots
        String unescaped = input.replace("\\.", ".");
        
        return unescaped;
    }

    public static void main(String[] args) {
        String input = "example\\.com";
        String result = unescapeId(input);
        System.out.println(result);  // Output: example.com
    }
}