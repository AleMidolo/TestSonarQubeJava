import java.io.InputStream;
import java.io.IOException;
import java.util.Stack;

public class FileAdder {

    /** 
     * Add the specified files in reverse order.
     */
    private void addReverse(final InputStream[] files) {
        Stack<InputStream> stack = new Stack<>();

        // Push all files onto the stack
        for (InputStream file : files) {
            stack.push(file);
        }

        // Pop files from the stack to process them in reverse order
        while (!stack.isEmpty()) {
            InputStream file = stack.pop();
            try {
                // Process the file (this is just a placeholder for actual file handling logic)
                processFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void processFile(InputStream file) throws IOException {
        // Placeholder for file processing logic
        // For example, read from the InputStream and perform necessary operations
        System.out.println("Processing file: " + file);
    }
}