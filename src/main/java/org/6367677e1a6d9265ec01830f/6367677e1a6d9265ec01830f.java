import java.text.SimpleDateFormat;
import java.util.Date;

public class LogFormatter {

    /**
     * Produce una cadena formateada según lo especificado por el patrón de conversión.
     * 
     * @param event El evento de registro que contiene la información a formatear.
     * @return Una cadena formateada según el patrón de conversión.
     */
    public String format(LoggingEvent event) {
        // Ejemplo de patrón de conversión: [timestamp] [level] message
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date(event.getTimeStamp()));
        String level = event.getLevel().toString();
        String message = event.getMessage();

        return String.format("[%s] [%s] %s", timestamp, level, message);
    }
}

// Clase de ejemplo para LoggingEvent
class LoggingEvent {
    private long timeStamp;
    private Level level;
    private String message;

    public LoggingEvent(long timeStamp, Level level, String message) {
        this.timeStamp = timeStamp;
        this.level = level;
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public Level getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}

// Enumeración de ejemplo para Level
enum Level {
    INFO, WARN, ERROR, DEBUG
}