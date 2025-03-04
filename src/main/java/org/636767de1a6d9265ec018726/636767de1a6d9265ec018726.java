import java.util.ArrayList;
import java.util.List;

public class SequenceRangeBuilder {

    private static class SequenceRange {
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
    }

    public List<SequenceRange> buildSequenceRanges() {
        List<SequenceRange> ranges = new ArrayList<>();
        
        // Assuming we have a list of profiles with sequence numbers
        List<Integer> profileSequences = getProfileSequences();
        
        if (profileSequences.isEmpty()) {
            return ranges;
        }

        // Sort sequences
        Collections.sort(profileSequences);
        
        int rangeStart = profileSequences.get(0);
        int prev = rangeStart;
        
        for (int i = 1; i < profileSequences.size(); i++) {
            int current = profileSequences.get(i);
            
            // If there's a gap in sequence, create new range
            if (current > prev + 1) {
                ranges.add(new SequenceRange(rangeStart, prev));
                rangeStart = current;
            }
            
            prev = current;
        }
        
        // Add final range
        ranges.add(new SequenceRange(rangeStart, prev));
        
        return ranges;
    }
    
    // Helper method to get profile sequences
    private List<Integer> getProfileSequences() {
        // Implementation would depend on how profile data is stored
        return new ArrayList<>(); 
    }
}