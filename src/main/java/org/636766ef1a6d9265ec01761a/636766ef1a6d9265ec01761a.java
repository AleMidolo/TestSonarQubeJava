import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private final Map<String, Integer> typeTable;
    private int nextIndex;

    public SymbolTable() {
        this.typeTable = new HashMap<>();
        this.nextIndex = 0;
    }

    /**
     * Aggiunge un tipo nella tabella dei tipi di questa tabella dei simboli. Non fa nulla se la tabella dei tipi contiene già un tipo simile.
     * @param value un nome di classe interno.
     * @return l'indice di un nuovo tipo o di un tipo già esistente con il valore fornito.
     */
    public int addType(final String value) {
        if (typeTable.containsKey(value)) {
            return typeTable.get(value);
        } else {
            typeTable.put(value, nextIndex);
            return nextIndex++;
        }
    }
}