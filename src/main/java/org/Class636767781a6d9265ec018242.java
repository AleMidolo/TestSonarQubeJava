package org;

import java.util.List;

public class Class636767781a6d9265ec018242 {
    private List<Appender> appenders;

    public Class636767781a6d9265ec018242(List<Appender> appenders) {
        this.appenders = appenders;
    }

    /** 
     * Chiama il metodo <code>doAppend</code> su tutti gli appender collegati.  
     */
    public int appendLoopOnAppenders(LoggingEvent event) {
        int appendCount = 0;
        for (Appender appender : appenders) {
            appender.doAppend(event);
            appendCount++;
        }
        return appendCount;
    }
}

interface Appender {
    void doAppend(LoggingEvent event);
}

class LoggingEvent {
    // Event details
}