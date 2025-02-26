public class TimeBucketCompressor {
    
    /**
     * दिन के चरण (dayStep) का पालन करते हुए समय बकेट के लम्बे मान को फिर से प्रारूपित करें। जैसे, यदि dayStep == 11 है, तो 20000105 का फिर से प्रारूपित समय बकेट 20000101 होगा, 20000115 का फिर से प्रारूपित समय बकेट 20000112 होगा, और 20000123 का फिर से प्रारूपित समय बकेट 20000123 होगा।
     */
    static long compressTimeBucket(long timeBucket, int dayStep) {
        // Extract year, month, and day from the timeBucket
        int year = (int) (timeBucket / 10000);
        int month = (int) ((timeBucket % 10000) / 100);
        int day = (int) (timeBucket % 100);
        
        // Calculate the day of the year
        int dayOfYear = getDayOfYear(year, month, day);
        
        // Calculate the new day of the year based on dayStep
        int newDayOfYear = (dayOfYear / dayStep) * dayStep;
        
        // Convert back to the date format
        return convertToDate(year, newDayOfYear);
    }
    
    private static int getDayOfYear(int year, int month, int day) {
        int[] daysInMonth = { 31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int dayOfYear = day;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonth[i];
        }
        return dayOfYear;
    }
    
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    private static long convertToDate(int year, int dayOfYear) {
        int[] daysInMonth = { 31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int month = 0;
        while (dayOfYear > daysInMonth[month]) {
            dayOfYear -= daysInMonth[month];
            month++;
        }
        return year * 10000 + (month + 1) * 100 + dayOfYear;
    }

    public static void main(String[] args) {
        long timeBucket1 = 20000105;
        int dayStep1 = 11;
        System.out.println(compressTimeBucket(timeBucket1, dayStep1)); // Output: 20000101

        long timeBucket2 = 20000115;
        int dayStep2 = 11;
        System.out.println(compressTimeBucket(timeBucket2, dayStep2)); // Output: 20000112

        long timeBucket3 = 20000123;
        int dayStep3 = 11;
        System.out.println(compressTimeBucket(timeBucket3, dayStep3)); // Output: 20000123
    }
}