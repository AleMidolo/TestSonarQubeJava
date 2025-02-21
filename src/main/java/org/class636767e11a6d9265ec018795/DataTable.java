package org.class636767e11a6d9265ec018795;

import java.util.Objects;

public class DataTable {
    private String bucketName;

    public DataTable(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }

    /**
     * @return true se il bucket è lo stesso.
     */
    public boolean isCompatible(DataTable dataset) {
        if (dataset == null) {
            return false;
        }
        return Objects.equals(this.bucketName, dataset.getBucketName());
    }
}