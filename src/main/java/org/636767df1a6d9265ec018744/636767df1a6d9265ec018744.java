import java.util.ArrayList;
import java.util.List;

public class TimeRangeSplitter {

    private static final long FETCH_DATA_DURATION = 3600000; // Example duration in milliseconds (1 hour)

    /**
     * Split time ranges to ensure the start time and end time is smaller than {@link #FETCH_DATA_DURATION}
     */
    protected List<TimeRange> buildTimeRanges(long start, long end) {
        List<TimeRange> timeRanges = new ArrayList<>();

        long currentStart = start;
        while (currentStart < end) {
            long currentEnd = Math.min(currentStart + FETCH_DATA_DURATION, end);
            timeRanges.add(new TimeRange(currentStart, currentEnd));
            currentStart = currentEnd;
        }

        return timeRanges;
    }

    public static class TimeRange {
        private long start;
        private long end;

        public TimeRange(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public long getStart() {
            return start;
        }

        public long getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "TimeRange{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        TimeRangeSplitter splitter = new TimeRangeSplitter();
        List<TimeRange> ranges = splitter.buildTimeRanges(0, 10000000); // Example usage
        for (TimeRange range : ranges) {
            System.out.println(range);
        }
    }
}