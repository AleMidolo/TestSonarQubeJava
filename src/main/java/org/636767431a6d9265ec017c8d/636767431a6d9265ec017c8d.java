public class BinaryLog {
    /**
     * Computes floor(log2(n)) + 1
     * @param n the input number
     * @return floor(log2(n)) + 1
     */
    private static int computeBinaryLog(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer.");
        }
        int log = 0;
        while (n > 1) {
            n = n >> 1;
            log++;
        }
        return log + 1;
    }

    public static void main(String[] args) {
        int n = 16; // Example input
        System.out.println("Binary log of " + n + " is: " + computeBinaryLog(n));
    }
}