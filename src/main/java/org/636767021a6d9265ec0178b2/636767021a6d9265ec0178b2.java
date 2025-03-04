import java.util.Stack;

public class FrameStack {
    private Stack<String> stack;

    private void pop(final String descriptor) {
        int index = 0;
        while (index < descriptor.length()) {
            char c = descriptor.charAt(index);
            switch (c) {
                case '(':
                    // Skip opening parenthesis for method descriptor
                    index++;
                    break;
                case ')':
                    // End of method arguments
                    return;
                case 'L':
                    // Object type - pop one element and skip to semicolon
                    stack.pop();
                    while (descriptor.charAt(index) != ';') {
                        index++;
                    }
                    index++;
                    break;
                case '[':
                    // Array type - skip brackets
                    while (descriptor.charAt(index) == '[') {
                        index++;
                    }
                    if (descriptor.charAt(index) == 'L') {
                        // Skip object type name
                        while (descriptor.charAt(index) != ';') {
                            index++;
                        }
                    }
                    stack.pop();
                    index++;
                    break;
                case 'B':
                case 'C': 
                case 'D':
                case 'F':
                case 'I':
                case 'J':
                case 'S':
                case 'Z':
                    // Primitive type - pop one element
                    stack.pop();
                    index++;
                    break;
                case 'V':
                    // Void type - no pop needed
                    index++;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid descriptor character: " + c);
            }
        }
    }
}