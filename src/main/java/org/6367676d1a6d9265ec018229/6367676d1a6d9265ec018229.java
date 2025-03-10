public class StringUtils {

    /**
     * 修剪给定字符串数组的元素，对每个元素调用 <code>String.trim()</code> 方法。
     * @param array 原始字符串数组
     * @return 包含修剪后的元素的结果数组（大小相同）
     */
    public static String[] trimArrayElements(String[] array) {
        if (array == null) {
            return null;
        }
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i] != null ? array[i].trim() : null;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] array = {"  hello ", "  world  ", null, "  java  "};
        String[] trimmedArray = trimArrayElements(array);
        for (String str : trimmedArray) {
            System.out.println("'" + str + "'");
        }
    }
}