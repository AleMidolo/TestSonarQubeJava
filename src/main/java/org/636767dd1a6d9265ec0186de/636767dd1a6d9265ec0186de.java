public class CacheUtil {

    /**
     * Determines if a metric should be removed from the cache based on the last update time and the expiration threshold.
     *
     * @param timestamp        The current time in milliseconds.
     * @param expiredThreshold The duration in milliseconds between the last update time and the time point for removing from cache.
     * @return true if the metric should be removed from the cache, otherwise false.
     */
    public static boolean isExpired(long timestamp, long expiredThreshold) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - timestamp) >= expiredThreshold;
    }

    public static void main(String[] args) {
        // Example usage
        long lastUpdateTime = System.currentTimeMillis() - 10000; // 10 seconds ago
        long threshold = 5000; // 5 seconds threshold

        if (isExpired(lastUpdateTime, threshold)) {
            System.out.println("Metric should be removed from cache.");
        } else {
            System.out.println("Metric is still valid.");
        }
    }
}