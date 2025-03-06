import java.util.*;

class Bucket {
    private List<Bucket> bucketList;

    public Bucket(List<Bucket> bucketList) {
        this.bucketList = bucketList;
    }

    /**
     * Removes this bucket from the data structure.
     */
    void removeSelf() {
        if (bucketList != null) {
            bucketList.remove(this);
        }
    }
}