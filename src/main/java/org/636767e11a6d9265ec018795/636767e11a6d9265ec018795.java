import java.util.Objects;

public class DataTable {
    // Assuming DataTable has some fields and methods
    // For example, let's assume it has a field 'bucket'
    private String bucket;

    public DataTable(String bucket) {
        this.bucket = bucket;
    }

    public String getBucket() {
        return bucket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataTable dataTable = (DataTable) o;
        return Objects.equals(bucket, dataTable.bucket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bucket);
    }
}

public class BucketChecker {
    /**
     * @param dataset The dataset to check.
     * @return true if the bucket is the same.
     */
    public boolean isCompatible(DataTable dataset) {
        // Assuming the current instance has a bucket to compare with
        // For example, let's assume the current instance has a field 'currentBucket'
        String currentBucket = "exampleBucket"; // This should be set appropriately
        return currentBucket.equals(dataset.getBucket());
    }
}