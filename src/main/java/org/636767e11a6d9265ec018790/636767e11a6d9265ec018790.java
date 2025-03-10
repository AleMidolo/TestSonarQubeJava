import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ThreadSnapshotParser {

    public static List<ThreadSnapshot> parseFromFileWithTimeRange(File file, List<ProfileAnalyzeTimeRange> timeRanges) throws IOException {
        List<ThreadSnapshot> snapshots = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));

        for (String line : lines) {
            ThreadSnapshot snapshot = parseLineToSnapshot(line);
            if (snapshot != null && isWithinTimeRange(snapshot, timeRanges)) {
                snapshots.add(snapshot);
            }
        }

        return snapshots;
    }

    private static ThreadSnapshot parseLineToSnapshot(String line) {
        // Assuming the line is in a specific format, parse it into a ThreadSnapshot object
        // Example format: "timestamp|threadId|threadName|state"
        String[] parts = line.split("\\|");
        if (parts.length == 4) {
            long timestamp = Long.parseLong(parts[0]);
            long threadId = Long.parseLong(parts[1]);
            String threadName = parts[2];
            String state = parts[3];
            return new ThreadSnapshot(timestamp, threadId, threadName, state);
        }
        return null;
    }

    private static boolean isWithinTimeRange(ThreadSnapshot snapshot, List<ProfileAnalyzeTimeRange> timeRanges) {
        for (ProfileAnalyzeTimeRange range : timeRanges) {
            if (snapshot.getTimestamp() >= range.getStartTime() && snapshot.getTimestamp() <= range.getEndTime()) {
                return true;
            }
        }
        return false;
    }

    public static class ThreadSnapshot {
        private long timestamp;
        private long threadId;
        private String threadName;
        private String state;

        public ThreadSnapshot(long timestamp, long threadId, String threadName, String state) {
            this.timestamp = timestamp;
            this.threadId = threadId;
            this.threadName = threadName;
            this.state = state;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public long getThreadId() {
            return threadId;
        }

        public String getThreadName() {
            return threadName;
        }

        public String getState() {
            return state;
        }
    }

    public static class ProfileAnalyzeTimeRange {
        private long startTime;
        private long endTime;

        public ProfileAnalyzeTimeRange(long startTime, long endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public long getStartTime() {
            return startTime;
        }

        public long getEndTime() {
            return endTime;
        }
    }
}