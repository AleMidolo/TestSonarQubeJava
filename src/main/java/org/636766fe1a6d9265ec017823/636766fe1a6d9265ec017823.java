import java.util.HashMap;
import java.util.Map;

public class ConstantPool {
    private final Map<String, Integer> constantNameAndTypeMap = new HashMap<>();
    private int nextIndex = 1;

    /**
     * Agrega una entrada CONSTANT_NameAndType_info de un grupo de constantes de esta tabla de símbolos.
     * No hace nada si el grupo de constantes ya contiene un elemento similar.
     *
     * @param name el nombre de un campo o método.
     * @param descriptor un descriptor de campo o método.
     * @return un nuevo símbolo o uno ya existente con el valor dado.
     */
    public int addConstantNameAndType(final String name, final String descriptor) {
        String key = name + ":" + descriptor;
        if (constantNameAndTypeMap.containsKey(key)) {
            return constantNameAndTypeMap.get(key);
        } else {
            constantNameAndTypeMap.put(key, nextIndex);
            return nextIndex++;
        }
    }
}