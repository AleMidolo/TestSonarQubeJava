package org.mappings;

public class MappingDiff {

    /**
     * Restituisce le mappature con i campi che non esistono nelle mappature di input. 
     * Le mappature di input devono essere le mappature storiche dall'indice corrente. 
     * Non restituire la configurazione _source per evitare conflitti di aggiornamento dell'indice corrente.
     */
    public Mappings diffStructure(String tableName, Mappings mappings) {
        // Simulazione delle mappature storiche
        Mappings historicalMappings = getHistoricalMappings(tableName);
        
        Mappings diffMappings = new Mappings();
        
        for (String field : historicalMappings.getFields().keySet()) {
            if (!mappings.getFields().containsKey(field)) {
                diffMappings.addField(field, historicalMappings.getFields().get(field));
            }
        }
        
        return diffMappings;
    }

    private Mappings getHistoricalMappings(String tableName) {
        // Simulazione di recupero delle mappature storiche
        Mappings historicalMappings = new Mappings();
        historicalMappings.addField("id", "integer");
        historicalMappings.addField("name", "string");
        historicalMappings.addField("email", "string");
        historicalMappings.addField("created_at", "date");
        return historicalMappings;
    }

    public static void main(String[] args) {
        MappingDiff mappingDiff = new MappingDiff();
        Mappings currentMappings = new Mappings();
        currentMappings.addField("id", "integer");
        currentMappings.addField("name", "string");

        Mappings diff = mappingDiff.diffStructure("users", currentMappings);
        System.out.println("Differenze nelle mappature:");
        for (Map.Entry<String, String> entry : diff.getFields().entrySet()) {
            System.out.println("Campo: " + entry.getKey() + ", Tipo: " + entry.getValue());
        }
    }
}