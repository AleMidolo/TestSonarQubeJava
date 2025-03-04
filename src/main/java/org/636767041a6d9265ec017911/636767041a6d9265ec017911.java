import java.util.HashSet;
import java.util.Set;

public class ObjectRegistry {
    // Static set to store registered objects
    private static final Set<Object> registeredObjects = new HashSet<>();
    
    /**
     * <p> Registers the given object. Used by the reflection methods to avoid infinite loops. </p>
     * @param value The object to register.
     */
    static void register(Object value) {
        if (value != null) {
            registeredObjects.add(value);
        }
    }
}