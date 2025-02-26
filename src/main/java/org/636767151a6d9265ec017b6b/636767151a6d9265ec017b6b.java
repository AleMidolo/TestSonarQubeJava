public class StringUtils {

    /** 
     * <p>检查一个字符串是否以指定的前缀开头（可选是否忽略大小写）。</p>
     * @see String#startsWith(String)
     * @param str  要检查的字符串，可能为空
     * @param prefix 要查找的前缀，可能为空
     * @param ignoreCase 指定比较是否应忽略大小写（不区分大小写）。
     * @return 如果字符串以前缀开头或两者都是 <code>null</code>则返回<code>true</code>
     */
    private static boolean startsWith(final String str, final String prefix, final boolean ignoreCase) {
        if (str == null && prefix == null) {
            return true;
        }
        if (str == null || prefix == null) {
            return false;
        }
        if (ignoreCase) {
            return str.toLowerCase().startsWith(prefix.toLowerCase());
        } else {
            return str.startsWith(prefix);
        }
    }

    public static void main(String[] args) {
        System.out.println(startsWith("HelloWorld", "Hello", false)); // true
        System.out.println(startsWith("HelloWorld", "hello", true));  // true
        System.out.println(startsWith("HelloWorld", "World", false)); // false
        System.out.println(startsWith(null, null, false));             // true
        System.out.println(startsWith(null, "Hello", false));         // false
    }
}