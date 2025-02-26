import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEventListener;

public class MyAtmosphereResource implements AtmosphereResource {

    @Override
    public AtmosphereResource addEventListener(AtmosphereResourceEventListener e) {
        // Implementation to add the event listener
        // This is a placeholder for the actual logic
        // You would typically store the listener in a list or map for later use
        System.out.println("Event listener added: " + e);
        return this; // Returning the current instance for method chaining
    }

    // Other methods and properties of AtmosphereResource would be implemented here
}