public class LongComparator {
    /**
     * 比较两个指定的 {@code long} 值。返回值的符号与 {@code ((Long) a).compareTo(b)} 的符号相同。
     * <p> <b>注意：对于 Java 7 及更高版本：</b>此方法应视为已弃用；请改用等效的 {@link Long#compare} 方法。
     * @param a 要比较的第一个 {@code long} 值
     * @param b 要比较的第二个 {@code long} 值
     * @return 如果 {@code a} 小于 {@code b}，则返回负值；如果 {@code a} 大于 {@code b}，则返回正值；如果它们相等，则返回零
     */
    private static int compareSigned(long a, long b) {
        if (a < b) {
            return -1;
        }
        if (a > b) {
            return 1;
        }
        return 0;
    }
}