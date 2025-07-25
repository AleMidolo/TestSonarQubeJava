package org.apache.commons.lang3;

/**
 * Utility class for Object operations.
 */
public class ObjectUtils {

    /**
     * <p>获取一个 <code>Object</code> 的 <code>toString</code> 值，如果输入为 <code>null</code> 则返回空字符串 ("")。</p> 
     * <pre> 
     * ObjectUtils.toString(null)         = "" 
     * ObjectUtils.toString("")           = "" 
     * ObjectUtils.toString("bat")        = "bat" 
     * ObjectUtils.toString(Boolean.TRUE) = "true" 
     * </pre>
     * @see StringUtils#defaultString(String)
     * @see String#valueOf(Object)
     * @param obj  要调用 <code>toString</code> 的对象，可以为 null
     * @return 传入对象的 toString 结果，如果输入为 <code>null</code> 则返回空字符串
     * @since 2.0
     */
    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }
}