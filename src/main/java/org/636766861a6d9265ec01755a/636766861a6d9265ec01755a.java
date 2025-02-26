import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UriMatcher {
    
    private static final String URI_PATTERN = "your-regex-pattern-here"; // Replace with your actual regex pattern

    /**
     * 将URI与模式进行匹配。
     * @param uri 要与模板匹配的URI。
     * @return 匹配结果，如果没有匹配则返回空。
     */
    public final MatchResult match(CharSequence uri) {
        Pattern pattern = Pattern.compile(URI_PATTERN);
        Matcher matcher = pattern.matcher(uri);
        
        if (matcher.matches()) {
            return new MatchResult(matcher);
        } else {
            return null; // No match found
        }
    }

    public static class MatchResult {
        private final Matcher matcher;

        public MatchResult(Matcher matcher) {
            this.matcher = matcher;
        }

        // Additional methods to retrieve matched groups can be added here
    }
}