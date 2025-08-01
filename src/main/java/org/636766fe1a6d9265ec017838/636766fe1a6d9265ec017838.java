public class ArrayConverter {
    /**
     * <p>将对象类型的 Character 数组转换为基本数据类型。</p> 
     * <p>对于输入数组 <code>null</code>，此方法返回 <code>null</code>。</p>
     * 
     * @param array  一个 <code>Character</code> 数组，可以为 <code>null</code>
     * @return 一个 <code>char</code> 数组，如果输入数组为空则返回 <code>null</code>
     * @throws NullPointerException 如果数组内容为 <code>null</code>
     */
    public static char[] toPrimitive(final Character[] array) {
        if (array == null) {
            return null;
        }
        
        final char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].charValue();
        }
        return result;
    }
}