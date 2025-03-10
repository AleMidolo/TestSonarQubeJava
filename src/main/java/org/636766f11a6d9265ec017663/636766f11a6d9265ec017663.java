public class ArrayUtils {

    /**
     * <p>检查两个数组是否具有相同的长度，将 <code>null</code> 数组视为长度 <code>0</code>。</p>
     * @param array1 第一个数组，可以为 <code>null</code>
     * @param array2 第二个数组，可以为 <code>null</code>
     * @return 如果数组的长度匹配则返回<code>true</code>，将 <code>null</code> 视为一个空数组
     */
    public static boolean isSameLength(final double[] array1, final double[] array2) {
        int length1 = (array1 == null) ? 0 : array1.length;
        int length2 = (array2 == null) ? 0 : array2.length;
        return length1 == length2;
    }

    public static void main(String[] args) {
        double[] array1 = {1.0, 2.0, 3.0};
        double[] array2 = {4.0, 5.0, 6.0};
        double[] array3 = null;
        double[] array4 = {7.0};

        System.out.println(isSameLength(array1, array2)); // true
        System.out.println(isSameLength(array1, array3)); // false
        System.out.println(isSameLength(array3, array4)); // false
    }
}