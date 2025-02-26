import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

public class BeanMap {
    private Map<String, Object> properties = new HashMap<>();

    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            throw new IllegalArgumentException("The provided BeanMap cannot be null.");
        }

        for (String propertyName : map.properties.keySet()) {
            try {
                PropertyDescriptor descriptor = new PropertyDescriptor(propertyName, this.getClass());
                if (descriptor.getWriteMethod() != null) {
                    this.properties.put(propertyName, map.properties.get(propertyName));
                }
            } catch (Exception e) {
                // Ignore properties that do not have a corresponding PropertyDescriptor
            }
        }
    }

    // Additional methods for BeanMap can be added here
}