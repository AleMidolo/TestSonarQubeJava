package org.class636767021a6d9265ec0178b2;

import java.util.Stack;

public class StackManipulator {
    private Stack<String> stack;

    public StackManipulator() {
        this.stack = new Stack<>();
    }

    /** 
     * Rimuove quanti più tipi astratti possibile dallo stack del frame di output come descritto dal descrittore fornito.
     * @param descriptor un tipo o un descrittore di metodo (nel qual caso vengono rimossi i suoi tipi di argomento).
     */
    private void pop(final String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            return;
        }

        // Simulating the removal of types based on the descriptor
        // For simplicity, let's assume the descriptor is a comma-separated list of types
        String[] typesToRemove = descriptor.split(",");

        for (String type : typesToRemove) {
            if (!stack.isEmpty() && stack.peek().equals(type.trim())) {
                stack.pop();
            }
        }
    }

    public void push(String type) {
        stack.push(type);
    }

    public Stack<String> getStack() {
        return stack;
    }

    public static void main(String[] args) {
        StackManipulator sm = new StackManipulator();
        sm.push("int");
        sm.push("String");
        sm.push("float");
        
        System.out.println("Stack before pop: " + sm.getStack());
        sm.pop("String, float");
        System.out.println("Stack after pop: " + sm.getStack());
    }
}