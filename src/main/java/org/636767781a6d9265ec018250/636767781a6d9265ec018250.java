import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class MyFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        // Implement your logic here to decide whether to accept, deny, or remain neutral
        // For example, if the message does not match a certain condition, return NEUTRAL
        if (!event.getMessage().toString().matches("your_regex_pattern")) {
            return Filter.NEUTRAL;
        }
        // Otherwise, return ACCEPT or DENY based on your criteria
        return Filter.ACCEPT; // or Filter.DENY
    }
}