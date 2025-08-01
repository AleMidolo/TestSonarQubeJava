import java.util.Objects;

public class ArrayConverter {
    /**
     * <p>将对象类型的 Byte 数组转换为基本数据类型的 byte 数组。</p> 
     * <p>对于 <code>null</code> 输入数组，此方法返回 <code>null</code>。</p>
     * 
     * @param array 一个 <code>Byte</code> 数组，可以是 <code>null</code>
     * @return 一个 <code>byte</code> 数组，如果输入数组为 null 则返回 <code>null</code>
     * @throws NullPointerException 如果数组内容为 <code>null</code>
     */
    public static byte[] toPrimitive(final Byte[] array) {
        if (array == null) {
            return null;
        }
        
        final byte[] result = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Objects.requireNonNull(array[i], "Array element at index " + i + " is null");
        }
        return result;
    }
}