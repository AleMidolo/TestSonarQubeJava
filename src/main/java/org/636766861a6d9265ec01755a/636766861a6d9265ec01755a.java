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
        } else {
            return null; // No match found
        }
    }

    public static class MatchResult {
        private final Matcher matcher;

        public MatchResult(Matcher matcher) {
            this.matcher = matcher;
        }

        public String group(int index) {
            return matcher.group(index);
        }

        public int start(int index) {
            return matcher.start(index);
        }

        public int end(int index) {
            return matcher.end(index);
        }

        public int groupCount() {
            return matcher.groupCount();
        }
    }
}