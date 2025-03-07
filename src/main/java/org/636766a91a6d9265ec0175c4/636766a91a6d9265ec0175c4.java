import java.util.Stack;

public class FrameStack {
    private Stack<Object> stack;

    public FrameStack() {
        stack = new Stack<>();
    }

    /**
     * आउटपुट फ्रेम स्टैक से जितने भी अमूर्त प्रकार हैं, उन्हें दिए गए वर्णनकर्ता के अनुसार पॉप करता है।
     * @param descriptor एक प्रकार या विधि वर्णनकर्ता (जिसमें इसके तर्क प्रकार पॉप होते हैं)।
     */
    private void pop(final String descriptor) {
        // Parse the descriptor to determine how many types to pop
        int numTypesToPop = countTypesInDescriptor(descriptor);

        // Pop the required number of types from the stack
        for (int i = 0; i < numTypesToPop; i++) {
            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                throw new IllegalStateException("Stack is empty, cannot pop more elements.");
            }
        }
    }

    /**
     * Helper method to count the number of types in the descriptor.
     * @param descriptor The descriptor string.
     * @return The number of types to pop.
     */
    private int countTypesInDescriptor(String descriptor) {
        // This is a simplified example. In a real implementation, you would need to parse
        // the descriptor string according to the JVM specification to determine the number of types.
        // For example, a method descriptor like "(I)D" has one argument (int) and returns a double.
        // Here, we assume the descriptor is a simple type name like "I" for int, "D" for double, etc.
        return descriptor.length();
    }

    // Example usage
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.stack.push(1); // Example: pushing an int
        frameStack.stack.push(2.0); // Example: pushing a double

        frameStack.pop("ID"); // Pop two elements corresponding to int and double
    }
}