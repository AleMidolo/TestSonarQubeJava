package org;

public class StackFrame {
    private final Stack<String> outputStack;

    public StackFrame() {
        this.outputStack = new Stack<>();
    }

    /** 
     * Rimuove il numero specificato di tipi astratti dallo stack del frame di output.
     * @param elements il numero di tipi astratti che devono essere rimossi.
     */
    private void pop(final int elements) {
        for (int i = 0; i < elements; i++) {
            if (!outputStack.isEmpty()) {
                outputStack.pop();
            } else {
                break; // Stop if the stack is empty
            }
        }
    }

    // Method to add elements to the stack for testing purposes
    public void push(String element) {
        outputStack.push(element);
    }

    // Method to view the current stack for testing purposes
    public Stack<String> getOutputStack() {
        return outputStack;
    }

    public static void main(String[] args) {
        StackFrame frame = new StackFrame();
        frame.push("Type1");
        frame.push("Type2");
        frame.push("Type3");

        System.out.println("Stack before pop: " + frame.getOutputStack());
        frame.pop(2);
        System.out.println("Stack after popping 2 elements: " + frame.getOutputStack());
    }
}