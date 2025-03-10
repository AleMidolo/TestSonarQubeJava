import java.util.concurrent.atomic.AtomicLong;

public class LastWriteTimeStamp {
    private final AtomicLong lastWriteTimeStamp = new AtomicLong();

    /**
     * 上一次写操作发生的时间，单位为毫秒。
     * @return this
     */
    public long lastWriteTimeStampInMilliseconds() {
        return lastWriteTimeStamp.get();
    }

    public void updateLastWriteTimeStamp() {
        lastWriteTimeStamp.set(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        LastWriteTimeStamp timeStamp = new LastWriteTimeStamp();
        timeStamp.updateLastWriteTimeStamp();
        System.out.println("Last write timestamp: " + timeStamp.lastWriteTimeStampInMilliseconds());
    }
}