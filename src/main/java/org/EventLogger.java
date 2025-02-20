package org;

import java.util.LinkedList;

public class EventLogger {
    private LinkedList<LoggingEvent> eventBuffer;

    public EventLogger() {
        eventBuffer = new LinkedList<>();
    }

    /** 
     * Aggiunge un <code>evento</code> come ultimo evento nel buffer.
     */
    public void add(LoggingEvent event) {
        eventBuffer.addLast(event);
    }

    // Assuming LoggingEvent is a class defined elsewhere
    public static class LoggingEvent {
        private String message;

        public LoggingEvent(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}