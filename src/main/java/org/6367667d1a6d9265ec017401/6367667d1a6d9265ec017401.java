public class StringUnescaper {

    /** 
     * <p>Unescapes any Java literals found in the <code>String</code>. For example, it will turn a sequence of <code>'\'</code> and <code>'n'</code> into a newline character, unless the <code>'\'</code> is preceded by another <code>'\'</code>.</p>
     * @param str the <code>String</code> to unescape, may be null
     * @return a new unescaped <code>String</code>, <code>null</code> if null string input
     */
    public static String unescapeJava(String str) throws Exception {
        if (str == null) {
            return null;
        }

        StringBuilder unescaped = new StringBuilder();
        boolean isEscaped = false;

        for (char c : str.toCharArray()) {
            if (isEscaped) {
                switch (c) {
                    case 'n':
                        unescaped.append('\n');
                        break;
                    case 't':
                        unescaped.append('\t');
                        break;
                    case 'r':
                        unescaped.append('\r');
                        break;
                    case 'b':
                        unescaped.append('\b');
                        break;
                    case 'f':
                        unescaped.append('\f');
                        break;
                    case '\"':
                        unescaped.append('\"');
                        break;
                    case '\'':
                        unescaped.append('\'');
                        break;
                    case '\\':
                        unescaped.append('\\');
                        break;
                    default:
                        unescaped.append(c);
                        break;
                }
                isEscaped = false;
            } else {
                if (c == '\\') {
                    isEscaped = true;
                } else {
                    unescaped.append(c);
                }
            }
        }

        // If the last character was an escape character, append it
        if (isEscaped) {
            unescaped.append('\\');
        }

        return unescaped.toString();
    }

    public static void main(String[] args) throws Exception {
        String testString = "Hello\\nWorld! This is a test string with a tab:\\t and a quote: \\\"";
        String result = unescapeJava(testString);
        System.out.println(result);
    }
}