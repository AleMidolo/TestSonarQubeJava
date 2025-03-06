import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ShardingKeyChecker {

    /**
     * Verifica si los índices de la clave de "sharding" son continuos.
     * 
     * @param modelName nombre del modelo de la entidad
     * @throws IllegalStateException si los índices de la clave de "sharding" no son continuos
     */
    private void check(String modelName) throws IllegalStateException {
        // Expresión regular para encontrar los índices de sharding en el nombre del modelo
        Pattern pattern = Pattern.compile("_shard(\\d+)");
        Matcher matcher = pattern.matcher(modelName);

        int previousIndex = -1;
        while (matcher.find()) {
            int currentIndex = Integer.parseInt(matcher.group(1));
            if (previousIndex != -1 && currentIndex != previousIndex + 1) {
                throw new IllegalStateException("Los índices de la clave de sharding no son continuos.");
            }
            previousIndex = currentIndex;
        }
    }

    public static void main(String[] args) {
        ShardingKeyChecker checker = new ShardingKeyChecker();
        try {
            checker.check("model_shard1_shard2_shard3"); // Ejemplo de uso
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}