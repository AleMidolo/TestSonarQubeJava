package org;

import java.util.Stack;

public class Class636766a91a6d9265ec0175c4 {
    private Stack<String> stack;

    public Class636766a91a6d9265ec0175c4() {
        this.stack = new Stack<>();
    }

    /**
     * Rimuove quanti più tipi astratti possibile dallo stack del frame di output come descritto dal descrittore fornito.
     * @param descriptor un tipo o un descrittore di metodo (nel qual caso vengono rimossi i suoi tipi di argomento).
     */
    private void pop(final String descriptor) {
        // Assuming descriptor is a method descriptor like "(I)V" for int parameter
        if (descriptor.startsWith("(") && descriptor.contains(")")) {
            int start = descriptor.indexOf('(') + 1;
            int end = descriptor.indexOf(')');
            String parameters = descriptor.substring(start, end);
            for (String type : parameters.split("")) {
                if (!type.isEmpty() && !stack.isEmpty()) {
                    stack.pop(); // Remove the top element for each parameter type
                }
            }
        } else {
            // If it's a single type, just pop once
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }
    }

    public void push(String type) {
        stack.push(type);
    }

    public String peek() {
        return stack.isEmpty() ? null : stack.peek();
    }

    public static void main(String[] args) {
        Class636766a91a6d9265ec0175c4 sm = new Class636766a91a6d9265ec0175c4();
        sm.push("Integer");
        sm.push("String");
        sm.push("Double");

        System.out.println("Stack before pop: " + sm.stack);
        sm.pop("(I)V"); // Example descriptor for a method with one int parameter
        System.out.println("Stack after pop: " + sm.stack);
    }
}