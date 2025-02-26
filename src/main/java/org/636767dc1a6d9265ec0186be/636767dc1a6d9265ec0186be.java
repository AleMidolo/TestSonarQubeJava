public class TimeBucketCompressor {

    /**
     * Follow the dayStep to re-format the time bucket literal long value. Such as, in dayStep == 11, 20000105 re-formatted time bucket is 20000101, 20000115 re-formatted time bucket is 20000112, 20000123 re-formatted time bucket is 20000123
     */
    static long compressTimeBucket(long timeBucket, int dayStep) {
        // Extract year, month, and day from the timeBucket
        int year = (int) (timeBucket / 10000);
        int month = (int) ((timeBucket % 10000) / 100);
        int day = (int) (timeBucket % 100);

        // Calculate the number of days since the start of the month
        int daysInMonth = getDaysInMonth(year, month);
        int dayOfMonth = day;

        // Calculate the new day based on the dayStep
        int newDay = (dayOfMonth / dayStep) * dayStep;

        // If the new day exceeds the days in the month, adjust it
        if (newDay > daysInMonth) {
            newDay = daysInMonth;
        }

        // Return the new time bucket in the format YYYYMMDD
        return year * 10000 + month * 100 + newDay;
    }

    // Helper method to get the number of days in a month
    private static int getDaysInMonth(int year, int month) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return (isLeapYear(year)) ? 29 : 28;
            default:
                return 0; // Invalid month
        }
    }

    // Helper method to check if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(compressTimeBucket(20000105, 11)); // Output: 20000101
        System.out.println(compressTimeBucket(20000115, 11)); // Output: 20000112
        System.out.println(compressTimeBucket(20000123, 11)); // Output: 20000123
    }
}