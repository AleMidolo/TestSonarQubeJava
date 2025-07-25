public class ArrayUtils {
    /**
     * 比较数组 <code>a</code> 和 <code>b</code> 中的前 <code>count</code> 个字节。
     * @param a     第一个要比较的数组。
     * @param b     第二个要比较的数组。
     * @param count 要比较的字节数。
     * @return 如果数组 <code>a</code> 和 <code>b</code> 中的前 <code>count</code> 个字节相等，则返回 <code>true</code>。
     */
    public static boolean arrayequals(byte[] a, byte[] b, int count) {
        if (a == b) {
            return true;
        }
        
        if (a == null || b == null) {
            return false;
        }
        
        if (count < 0) {
            return false;
        }
        
        if (a.length < count || b.length < count) {
            return false;
        }
        
        for (int i = 0; i < count; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        
        return true;
    }
}