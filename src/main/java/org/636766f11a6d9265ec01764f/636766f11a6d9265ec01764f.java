import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BeanMap {
    private Map<String, Object> map;

    public BeanMap() {
        this.map = new HashMap<>();
    }

    /**
     * Returns the values for the BeanMap.
     * @return values for the BeanMap. The returned collection is not modifiable.
     */
    public Collection<Object> values() {
        return Collections.unmodifiableCollection(map.values());
    }

    // Additional methods to add and manage entries in the BeanMap
    public void put(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }
}