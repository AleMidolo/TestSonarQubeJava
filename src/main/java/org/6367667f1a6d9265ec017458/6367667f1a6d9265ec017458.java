import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;

public class AtmosphereFramework {
    // Assuming a map to store the handlers with their mappings
    private java.util.Map<String, AtmosphereHandler> handlers = new java.util.HashMap<>();

    /**
     * Remove an {@link AtmosphereHandler}.
     * @param mapping the mapping used when invoking {@link #addAtmosphereHandler(String, AtmosphereHandler)};
     * @return true if removed
     */
    public boolean removeAtmosphereHandler(String mapping) {
        if (handlers.containsKey(mapping)) {
            handlers.remove(mapping);
            return true;
        }
        return false;
    }

    // Assuming this method exists to add handlers
    public void addAtmosphereHandler(String mapping, AtmosphereHandler handler) {
        handlers.put(mapping, handler);
    }
}