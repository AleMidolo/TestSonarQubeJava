import java.util.HashMap;
import java.util.Map;

public class Mappings {
    private Map<String, Object> properties;

    public Mappings() {
        this.properties = new HashMap<>();
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}

public class MappingDiff {

    /**
     * Returns mappings with fields that do not exist in the input mappings. The input mappings should be history mapping from current index. Do not return _source config to avoid current index update conflict.
     *
     * @param tableName The name of the table.
     * @param mappings The current mappings to compare against.
     * @return A new Mappings object containing only the fields that are not present in the input mappings.
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        Mappings result = new Mappings();
        Map<String, Object> currentProperties = getCurrentMappings(tableName).getProperties();
        Map<String, Object> inputProperties = mappings.getProperties();

        for (Map.Entry<String, Object> entry : currentProperties.entrySet()) {
            String fieldName = entry.getKey();
            if (!inputProperties.containsKey(fieldName)) {
                result.getProperties().put(fieldName, entry.getValue());
            }
        }

        return result;
    }

    // Dummy method to simulate fetching current mappings for a table
    private Mappings getCurrentMappings(String tableName) {
        Mappings currentMappings = new Mappings();
        Map<String, Object> properties = new HashMap<>();
        properties.put("field1", "type1");
        properties.put("field2", "type2");
        properties.put("field3", "type3");
        currentMappings.setProperties(properties);
        return currentMappings;
    }

    public static void main(String[] args) {
        MappingDiff diff = new MappingDiff();
        Mappings inputMappings = new Mappings();
        Map<String, Object> inputProperties = new HashMap<>();
        inputProperties.put("field1", "type1");
        inputMappings.setProperties(inputProperties);

        Mappings result = diff.diffStructure("exampleTable", inputMappings);
        System.out.println(result.getProperties()); // Output: {field2=type2, field3=type3}
    }
}