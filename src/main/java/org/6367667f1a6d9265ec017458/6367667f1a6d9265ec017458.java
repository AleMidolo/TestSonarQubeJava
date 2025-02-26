import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereHandler;

public class AtmosphereHandlerManager {
    private AtmosphereFramework atmosphereFramework;

    public AtmosphereHandlerManager() {
        atmosphereFramework = new AtmosphereFramework();
    }

    /**
     * एक {@link AtmosphereHandler} को हटाएं।
     * @param mapping वह मैपिंग है जो {@link #addAtmosphereHandler(String,AtmosphereHandler)} को कॉल करते समय उपयोग की जाती है;
     * @return यदि हटाया गया है तो true
     */
    public boolean removeAtmosphereHandler(String mapping) {
        AtmosphereHandler handler = atmosphereFramework.getAtmosphereHandler(mapping);
        if (handler != null) {
            atmosphereFramework.removeAtmosphereHandler(mapping);
            return true;
        }
        return false;
    }
}