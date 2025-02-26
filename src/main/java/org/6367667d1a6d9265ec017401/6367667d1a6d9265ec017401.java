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

        StringBuilder result = new StringBuilder();
        boolean isEscaped = false;

        for (char currentChar : str.toCharArray()) {
            if (isEscaped) {
                switch (currentChar) {
                    case 'n':
                        result.append('\n');
                        break;
                    case 't':
                        result.append('\t');
                        break;
                    case 'r':
                        result.append('\r');
                        break;
                    case 'f':
                        result.append('\f');
                        break;
                    case 'b':
                        result.append('\b');
                        break;
                    case '"':
                        result.append('"');
                        break;
                    case '\'':
                        result.append('\'');
                        break;
                    case '\\':
                        result.append('\\');
                        break;
                    default:
                        result.append(currentChar);
                        break;
                }
                isEscaped = false;
            } else {
                if (currentChar == '\\') {
                    isEscaped = true;
                } else {
                    result.append(currentChar);
                }
            }
        }

        // If the last character was an escape character, append it
        if (isEscaped) {
            result.append('\\');
        }

        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        String testString = "Hello\\nWorld! This is a test string with a tab:\\t and a quote: \\\"";
        String unescapedString = unescapeJava(testString);
        System.out.println(unescapedString);
    }
}