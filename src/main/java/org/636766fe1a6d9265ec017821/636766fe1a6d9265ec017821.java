import java.util.Arrays;

/**
 * <p>将 <code>byte</code> 数组的详细信息附加到 <code>toString</code> 中。</p>
 * @param buffer  要填充的 <code>StringBuffer</code>
 * @param fieldName  字段名称，通常不使用，因为已经附加
 * @param array  要添加到 <code>toString</code> 的数组，不能为 <code>null</code>
 */
protected void appendDetail(StringBuffer buffer, String fieldName, byte[] array) {
    if (array == null) {
        throw new IllegalArgumentException("The byte array must not be null");
    }
    
    buffer.append(Arrays.toString(array));
}