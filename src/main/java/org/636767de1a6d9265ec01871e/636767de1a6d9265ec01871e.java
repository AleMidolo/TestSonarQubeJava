import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ShardingKeyChecker {

    /**
     * Checks if the sharding key indices in the model name are continuous.
     * 
     * @param modelName model name of the entity
     * @throws IllegalStateException if sharding key indices are not continuous
     */
    private void check(String modelName) throws IllegalStateException {
        if (modelName == null || modelName.isEmpty()) {
            throw new IllegalStateException("Model name cannot be null or empty.");
        }

        // Extract sharding key indices from the model name
        Pattern pattern = Pattern.compile("_\\d+");
        Matcher matcher = pattern.matcher(modelName);

        int previousIndex = -1;
        while (matcher.find()) {
            String match = matcher.group();
            int currentIndex = Integer.parseInt(match.substring(1)); // Remove the underscore

            if (previousIndex != -1 && currentIndex != previousIndex + 1) {
                throw new IllegalStateException("Sharding key indices are not continuous.");
            }

            previousIndex = currentIndex;
        }
    }

    public static void main(String[] args) {
        ShardingKeyChecker checker = new ShardingKeyChecker();
        try {
            checker.check("model_1_2_3"); // This should pass
            checker.check("model_1_3_4"); // This should throw an exception
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}