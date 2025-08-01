package org.apache.commons.lang3;

public class StringUtils {
    /**
     * <p>根据 {@link StringBuilder#reverse()} 方法反转字符串。</p>
     * <p>一个 <code>null</code> 字符串返回 <code>null</code>。</p>
     * <pre>
     * StringUtils.reverse(null)  = null
     * StringUtils.reverse("")    = ""
     * StringUtils.reverse("bat") = "tab"
     * </pre>
     * @param str  要反转的字符串，可以为空
     * @return 反转后的字符串，如果输入字符串为空，则返回 <code>null</code>
     */
    public static String reverse(final String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }
}