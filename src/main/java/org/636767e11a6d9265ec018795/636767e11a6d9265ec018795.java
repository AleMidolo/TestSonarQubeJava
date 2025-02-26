public class DataTable {
    // Assuming DataTable has a bucket property for demonstration purposes
    private String bucket;

    public DataTable(String bucket) {
        this.bucket = bucket;
    }

    public String getBucket() {
        return bucket;
    }
}

public class CompatibilityChecker {
    private String bucket;

    public CompatibilityChecker(String bucket) {
        this.bucket = bucket;
    }

    /** 
     * @return true se il bucket è lo stesso.
     */
    public boolean isCompatible(DataTable dataset) {
        return this.bucket.equals(dataset.getBucket());
    }

    public static void main(String[] args) {
        CompatibilityChecker checker = new CompatibilityChecker("bucket1");
        DataTable dataset = new DataTable("bucket1");
        
        System.out.println(checker.isCompatible(dataset)); // Should print true
    }
}