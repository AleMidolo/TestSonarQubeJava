import java.util.Arrays;

public class ArrayUtils {
    
    /** 
     * 返回一个不包含空元素的新字符串数组。此内部方法用于规范化排除列表（数组和集合）。请注意，如果数组元素为 <code>null</code>，{@link Arrays#sort(Object[])} 将抛出 {@link NullPointerException}。
     * @param array 要检查的数组
     * @return 给定数组或一个不包含空值的新数组。
     */
    static String[] toNoNullStringArray(Object[] array) {
        if (array == null) {
            return new String[0];
        }
        
        return Arrays.stream(array)
                     .filter(obj -> obj != null)
                     .map(Object::toString)
                     .toArray(String[]::new);
    }
    
    public static void main(String[] args) {
        Object[] inputArray = { "Hello", null, "World", null, "!" };
        String[] resultArray = toNoNullStringArray(inputArray);
        System.out.println(Arrays.toString(resultArray)); // Output: [Hello, World, !]
    }
}