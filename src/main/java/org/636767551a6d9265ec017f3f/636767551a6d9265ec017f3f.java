public class ArrayUtils {
    /**
     * 交换给定数组中指定索引的两个元素。
     * @param <V> 数组中元素的类型
     * @param arr 数组
     * @param i 第一个元素的索引
     * @param j 第二个元素的索引
     */
    public static final <V> void swap(V[] arr, int i, int j) {
        if (arr == null || arr.length == 0) {
            return;
        }
        
        if (i < 0 || i >= arr.length || j < 0 || j >= arr.length) {
            throw new IndexOutOfBoundsException("Invalid array indices");
        }
        
        V temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}