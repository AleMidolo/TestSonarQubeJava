public class StringUtils {
    /**
     * 获取字符串的长度，如果字符串为 <code>null</code> 则返回 <code>0</code>。
     * @param str 一个字符串或 <code>null</code>
     * @return 字符串的长度，如果字符串为 <code>null</code> 则返回 <code>0</code>。
     * @since 2.4
     */
    public static int length(final String str) {
        return str == null ? 0 : str.length();
    }
}