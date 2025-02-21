package org.class636767781a6d9265ec018250;

import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.Filter;

public class FilterDecider {

    /**
     * Restituisce {@link Filter#NEUTRAL} se non c'è corrispondenza con la stringa.
     */
    public int decide(LoggingEvent event) {
        // Implementazione della logica per decidere il filtro
        String message = event.getRenderedMessage();
        String searchString = "corrispondenza"; // Stringa da cercare

        if (message == null || !message.contains(searchString)) {
            return Filter.NEUTRAL; // Restituisce NEUTRAL se non c'è corrispondenza
        }

        // Altre logiche di decisione possono essere aggiunte qui
        return Filter.ACCEPT; // Esempio di restituzione se c'è corrispondenza
    }
}