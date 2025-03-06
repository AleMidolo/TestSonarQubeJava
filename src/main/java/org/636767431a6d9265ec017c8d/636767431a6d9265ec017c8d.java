/**
 * Computes floor(log2(n)) + 1
 */
private int computeBinaryLog(int n) {
    if (n <= 0) {
        throw new IllegalArgumentException("n must be a positive integer");
    }
    int log = 0;
    while (n > 1) {
        n = n >> 1;
        log++;
    }
    return log + 1;
}