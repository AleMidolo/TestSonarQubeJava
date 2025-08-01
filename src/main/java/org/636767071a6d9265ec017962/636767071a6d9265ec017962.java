import org.apache.commons.beanutils.BeanMap;
import java.util.Iterator;

public class BeanMapUtils {
    
    /**
     * 将给定 BeanMap 中所有可写属性放入此 BeanMap。只读和只写属性将被忽略。
     * @param map 要放入的 BeanMap
     */
    public void putAllWriteable(BeanMap map) {
        if (map == null) {
            return;
        }

        Iterator<?> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            @SuppressWarnings("unchecked")
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) entries.next();
            String propertyName = entry.getKey();
            
            // Check if property is writeable
            if (map.getWriteMethod(propertyName) != null) {
                Object value = entry.getValue();
                try {
                    // Put only if property is writeable
                    this.put(propertyName, value);
                } catch (Exception e) {
                    // Ignore exceptions for read-only or write-only properties
                }
            }
        }
    }
}