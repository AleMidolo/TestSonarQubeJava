import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;
import java.io.IOException;
import java.io.Writer;

public class CustomAppender extends AppenderSkeleton {
    
    private Writer writer;
    
    public CustomAppender(Writer writer) {
        this.writer = writer;
    }

    /**
     * This method does actual writing
     */
    protected void subAppend(LoggingEvent event) {
        if(layout == null || writer == null) {
            return;
        }

        try {
            String formattedMessage = layout.format(event);
            writer.write(formattedMessage);
            
            if(layout.ignoresThrowable()) {
                String[] throwableStrRep = event.getThrowableStrRep();
                if(throwableStrRep != null) {
                    for(String line : throwableStrRep) {
                        writer.write(line);
                        writer.write(Layout.LINE_SEP);
                    }
                }
            }
            
            writer.flush();
        } catch(IOException e) {
            errorHandler.error("Failed to write log event", e, 1);
        }
    }

    @Override
    public void close() {
        if(writer != null) {
            try {
                writer.close();
            } catch(IOException e) {
                // Ignore
            }
        }
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}