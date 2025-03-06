import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ThreadSnapshotParser {

    public static List<ThreadSnapshot> parseFromFileWithTimeRange(File file, List<ProfileAnalyzeTimeRange> timeRanges) throws IOException {
        List<ThreadSnapshot> snapshots = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));

        for (String line : lines) {
            ThreadSnapshot snapshot = ThreadSnapshot.fromString(line);
            if (snapshot != null && isWithinTimeRange(snapshot, timeRanges)) {
                snapshots.add(snapshot);
            }
        }

        return snapshots;
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
        private String threadName;
        private String state;

        public ThreadSnapshot(long timestamp, String threadName, String state) {
            this.timestamp = timestamp;
            this.threadName = threadName;
            this.state = state;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public String getThreadName() {
            return threadName;
        }

        public String getState() {
            return state;
        }

        public static ThreadSnapshot fromString(String line) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                try {
                    long timestamp = Long.parseLong(parts[0]);
                    String threadName = parts[1];
                    String state = parts[2];
                    return new ThreadSnapshot(timestamp, threadName, state);
                } catch (NumberFormatException e) {
                    return null;
                }
            }
            return null;
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