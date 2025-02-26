import java.util.Stack;

public class FrameStack {
    private Stack<Object> stack;

    public FrameStack() {
        this.stack = new Stack<>();
    }

    /**
     * आउटपुट फ्रेम स्टैक से जितने भी अमूर्त प्रकार हैं, उन्हें दिए गए वर्णनकर्ता के अनुसार पॉप करता है।
     * @param descriptor एक प्रकार या विधि का वर्णनकर्ता (जिसमें इसके तर्क प्रकार पॉप होते हैं)।
     */
    private void pop(final String descriptor) {
        // Assuming descriptor is a string representation of types
        String[] types = descriptor.split(",");
        for (String type : types) {
            if (!stack.isEmpty()) {
                Object poppedValue = stack.pop();
                // Here you can add logic to check if poppedValue matches the type
                // For simplicity, we are just popping values without type checking
                System.out.println("Popped: " + poppedValue);
            } else {
                System.out.println("Stack is empty, cannot pop.");
                break;
            }
        }
    }

    public void push(Object value) {
        stack.push(value);
    }

    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.push(1);
        frameStack.push("Hello");
        frameStack.push(3.14);
        
        frameStack.pop("Integer,String"); // Example usage
    }
}