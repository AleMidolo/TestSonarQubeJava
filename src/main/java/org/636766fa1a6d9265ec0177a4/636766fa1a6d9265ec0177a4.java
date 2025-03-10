public class ArrayConverter {
    /**
     * <p>将基本数据类型的 double 数组转换为对象类型。</p> <p>对于输入数组 <code>null</code>，此方法返回 <code>null</code>。</p>
     * @param array  一个 <code>double</code> 数组
     * @return 一个 <code>Double</code> 数组，如果输入数组为空则返回 <code>null</code>
     */
    public static Double[] toObject(final double[] array) {
        if (array == null) {
            return null;
        }
        Double[] result = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }
}