package org.class636767de1a6d9265ec018706;

import java.util.HashMap;
import java.util.Map;


public class Mappings {

    private Map<String, String> fields;

    public Mappings() {
        this.fields = new HashMap<>();
    }

    public void addField(String fieldName, String fieldType) {
        fields.put(fieldName, fieldType);
    }

    public Map<String, String> getFields() {
        return fields;
    }
}