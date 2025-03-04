import java.util.*;

public class BucketLabeler {
    
    public void moveVerticesFromMinLabelBucketToZero(
        Map<Integer, Set<Integer>> bucketsByLabel,
        Map<Integer, Integer> labels,
        int minLabel
    ) {
        // Get the bucket with minLabel
        Set<Integer> minLabelBucket = bucketsByLabel.get(minLabel);
        
        if (minLabelBucket == null || minLabelBucket.isEmpty()) {
            return;
        }
        
        // Get or create bucket 0
        Set<Integer> zeroBucket = bucketsByLabel.computeIfAbsent(0, k -> new HashSet<>());
        
        // Move all vertices from minLabel bucket to zero bucket
        for (Integer vertex : minLabelBucket) {
            // Update the label for each vertex to 0
            labels.put(vertex, 0);
            // Add vertex to zero bucket
            zeroBucket.add(vertex);
        }
        
        // Clear the minLabel bucket
        minLabelBucket.clear();
        
        // Remove empty bucket if it exists
        bucketsByLabel.remove(minLabel);
    }
}