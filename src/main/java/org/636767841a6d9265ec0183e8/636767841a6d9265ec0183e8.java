import org.apache.log4j.spi.LoggingEvent;
import java.util.ArrayList;
import java.util.List;

public class EventBuffer {
    private List<LoggingEvent> buffer;

    public EventBuffer() {
        this.buffer = new ArrayList<>();
    }

    /** 
     * 将一个<code>event</code>添加为缓冲区中的最后一个事件。
     */
    public void add(LoggingEvent event) {
        if (event != null) {
            buffer.add(event);
        }
    }

    // Optional: Method to get the buffer for testing or other purposes
    public List<LoggingEvent> getBuffer() {
        return buffer;
    }
}