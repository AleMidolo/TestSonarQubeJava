import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONWriter;

public class JsonSerializer {

    /**
     * 序列化为 JSON {@link String}
     * @param features 在序列化中启用的特性
     * @return JSON {@link String}
     */
    @SuppressWarnings("unchecked")
    public String toString(JSONWriter.Feature... features) {
        // Example object to serialize
        MyObject obj = new MyObject("example", 123);
        
        // Serialize the object to JSON string with the provided features
        return JSON.toJSONString(obj, features);
    }

    // Example class to serialize
    public static class MyObject {
        private String name;
        private int value;

        public MyObject(String name, int value) {
            this.name = name;
            this.value = value;
        }

        // Getters and setters (if needed)
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        JsonSerializer serializer = new JsonSerializer();
        String jsonString = serializer.toString(JSONWriter.Feature.PrettyFormat);
        System.out.println(jsonString);
    }
}