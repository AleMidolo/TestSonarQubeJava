package org.class636767531a6d9265ec017efb;



public class BucketList {

    private Bucket head;

    public BucketList() {
        this.head = null;
    }

    /**
     * Inserisce questo bucket nella struttura dati prima del {@code bucket}.
     * @param bucket il bucket, che sarà il successivo a questo bucket.
     */
    public void insertBefore(Bucket bucket) {
        if (head == null || bucket == null) {
            // No insertion if the list is empty or bucket is null
            return;
        }
        // Create a new bucket to insert
        Bucket newBucket = new Bucket("New Bucket");
        if (head == bucket) {
            newBucket.setNext(head);
            // Insert at the head
            head = newBucket;
            return;
        }
        Bucket current = head;
        while (current != null && current.getNext() != bucket) {
            current = current.getNext();
        }
        if (current != null) {
            newBucket.setNext(bucket);
            // Insert before the specified bucket
            current.setNext(newBucket);
        }
    }

    // Additional methods for testing purposes
    public void printList() {
        Bucket current = head;
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        BucketList list = new BucketList();
        Bucket bucket1 = new Bucket("Bucket 1");
        Bucket bucket2 = new Bucket("Bucket 2");
        // Should not insert anything
        list.insertBefore(bucket1);
        // Should not insert anything
        list.insertBefore(bucket2);
        // Manually linking for demonstration
        list.head = bucket1;
        bucket1.setNext(bucket2);
        System.out.println("Before insertion:");
        list.printList();
        // Insert before bucket2
        list.insertBefore(bucket2);
        System.out.println("After insertion:");
        list.printList();
    }
}