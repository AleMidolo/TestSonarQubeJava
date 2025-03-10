import org.apache.log4j.spi.LoggingEvent;

/**
 * This method does actual writing
 */
protected void subAppend(LoggingEvent event) {
    // Implementation of the actual writing logic
    // For example, writing the log message to a file or console
    System.out.println(event.getMessage());
}