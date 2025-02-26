import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UriMatcher {
    
    private final String pattern;

    public UriMatcher(String pattern) {
        this.pattern = pattern;
    }

    /** 
     * 将URI与模式进行匹配。
     * @param uri 要与模板匹配的URI。
     * @return 匹配结果，如果没有匹配则返回空。
     */
    public final MatchResult match(CharSequence uri) {
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(uri);
        
        if (matcher.matches()) {
            return new MatchResult(matcher);
        }
        return null; // No match found
    }

    public static class MatchResult {
        private final Matcher matcher;

        public MatchResult(Matcher matcher) {
            this.matcher = matcher;
        }

        public String group(int group) {
            return matcher.group(group);
        }

        public int groupCount() {
            return matcher.groupCount();
        }
    }

    public static void main(String[] args) {
        UriMatcher uriMatcher = new UriMatcher("^(http|https)://.*$");
        MatchResult result = uriMatcher.match("https://example.com");
        
        if (result != null) {
            System.out.println("Matched! Group count: " + result.groupCount());
        } else {
            System.out.println("No match found.");
        }
    }
}