package org;

import java.util.ArrayList;
import java.util.List;

public class SequenceRangeBuilder {

    /** 
     * costruisce l'intervallo di sequenze per lo snapshot dei profili correnti
     */
    public List<SequenceRange> buildSequenceRanges() {
        List<SequenceRange> sequenceRanges = new ArrayList<>();
        
        // Example logic to build sequence ranges
        // This is just a placeholder; actual logic will depend on specific requirements
        for (int i = 0; i < 10; i++) {
            SequenceRange range = new SequenceRange(i * 10, (i + 1) * 10 - 1);
            sequenceRanges.add(range);
        }
        
        return sequenceRanges;
    }

    public static void main(String[] args) {
        SequenceRangeBuilder builder = new SequenceRangeBuilder();
        List<SequenceRange> ranges = builder.buildSequenceRanges();
        for (SequenceRange range : ranges) {
            System.out.println(range);
        }
    }
}

class SequenceRange {
    private int start;
    private int end;

    public SequenceRange(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "SequenceRange{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}