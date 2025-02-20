package org;

import java.util.Stack;

public class AbstractTypeStack {
    private Stack<Integer> stack;

    public AbstractTypeStack() {
        stack = new Stack<>();
    }

    /**
     * Estrae un tipo astratto dallo stack del frame di output e restituisce il suo valore.
     * @return il tipo astratto che è stato estratto dallo stack del frame di output.
     */
    private int pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }
        return stack.pop();
    }

    // Method to push an element onto the stack for testing purposes
    public void push(int value) {
        stack.push(value);
    }

    // Main method for testing
    public static void main(String[] args) {
        AbstractTypeStack abstractTypeStack = new AbstractTypeStack();
        abstractTypeStack.push(10);
        abstractTypeStack.push(20);
        System.out.println("Popped value: " + abstractTypeStack.pop()); // Should print 20
        System.out.println("Popped value: " + abstractTypeStack.pop()); // Should print 10
    }
}