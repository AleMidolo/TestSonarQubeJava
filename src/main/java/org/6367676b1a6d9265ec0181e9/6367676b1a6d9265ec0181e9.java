public class SubstringMatcher {

    /**
     * 如果给定的字符串在指定索引处与给定的子字符串匹配，则返回 {@code true}，否则返回 {@code false}。
     * @param str 原始字符串（或 StringBuilder）
     * @param index 在原始字符串中开始匹配的索引
     * @param substring 要在给定索引处匹配的子字符串
     * @return 如果给定的字符串在指定索引处与给定的子字符串匹配，则返回 {@code true}，否则返回 {@code false}。
     */
    public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
        if (str == null || substring == null) {
            return false;
        }
        if (index < 0 || index + substring.length() > str.length()) {
            return false;
        }
        for (int i = 0; i < substring.length(); i++) {
            if (str.charAt(index + i) != substring.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 测试用例
        CharSequence str = "Hello, World!";
        CharSequence substring = "World";
        int index = 7;

        boolean result = substringMatch(str, index, substring);
        System.out.println(result); // 输出: true
    }
}