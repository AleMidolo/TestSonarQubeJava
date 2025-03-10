import com.google.gson.JsonObject;
import java.util.List;

public class PropertyConverter {

    /**
     * Convertir propiedades del proceso a datos de origen
     * @param properties Lista de pares clave-valor
     * @return JsonObject con las propiedades convertidas
     */
    private JsonObject convertProperties(List<KeyStringValuePair> properties) {
        JsonObject jsonObject = new JsonObject();
        for (KeyStringValuePair pair : properties) {
            jsonObject.addProperty(pair.getKey(), pair.getValue());
        }
        return jsonObject;
    }
}

class KeyStringValuePair {
    private String key;
    private String value;

    public KeyStringValuePair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}