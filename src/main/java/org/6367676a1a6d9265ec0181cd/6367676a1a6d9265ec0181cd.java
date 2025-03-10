public class StringUtils {

    /**
     * 去除给定字符串的前导空白字符。
     * @param str 要检查的字符串
     * @return 去除空白后的字符串
     * @see java.lang.Character#isWhitespace
     */
    public static String trimLeadingWhitespace(String str) {
        if (str == null) {
            return null;
        }
        int len = str.length();
        int st = 0;
        while ((st < len) && Character.isWhitespace(str.charAt(st))) {
            st++;
        }
        return st > 0 ? str.substring(st) : str;
    }

    public static void main(String[] args) {
        String input = "   Hello, World!";
        String output = trimLeadingWhitespace(input);
        System.out.println(output);  // 输出: "Hello, World!"
    }
}