import java.util.ArrayList;
import java.util.List;

public class SequenceRange {
    private int start;
    private int end;

    public SequenceRange(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "SequenceRange{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class ProfileSnapshot {

    /**
     * costruisce l'intervallo di sequenze per lo snapshot dei profili correnti
     */
    public List<SequenceRange> buildSequenceRanges() {
        List<SequenceRange> sequenceRanges = new ArrayList<>();
        
        // Example logic to build sequence ranges
        // This is a placeholder and should be replaced with actual logic
        sequenceRanges.add(new SequenceRange(1, 100));
        sequenceRanges.add(new SequenceRange(101, 200));
        sequenceRanges.add(new SequenceRange(201, 300));

        return sequenceRanges;
    }

    public static void main(String[] args) {
        ProfileSnapshot snapshot = new ProfileSnapshot();
        List<SequenceRange> ranges = snapshot.buildSequenceRanges();
        for (SequenceRange range : ranges) {
            System.out.println(range);
        }
    }
}