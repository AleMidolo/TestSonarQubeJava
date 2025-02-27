public class OperationTracker {
    private long lastWriteTimeStamp;

    public OperationTracker() {
        this.lastWriteTimeStamp = System.currentTimeMillis();
    }

    /**
     * La última vez, en milisegundos, que ocurrió una operación de escritura.
     * @return esto
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimeStamp;
    }

    public void writeOperation() {
        // Simulate a write operation
        lastWriteTimeStamp = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        OperationTracker tracker = new OperationTracker();
        System.out.println("Last write timestamp: " + tracker.lastWriteTimeStampInMilliseconds());
        tracker.writeOperation();
        System.out.println("Updated write timestamp: " + tracker.lastWriteTimeStampInMilliseconds());
    }
}