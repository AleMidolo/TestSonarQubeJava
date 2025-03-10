import java.util.Stack;

public class FrameStack {
    private Stack<String> outputStack = new Stack<>();

    /**
     * Rimuove quanti più tipi astratti possibile dallo stack del frame di output come descritto dal descrittore fornito.
     * @param descriptor un tipo o un descrittore di metodo (nel qual caso vengono rimossi i suoi tipi di argomento).
     */
    private void pop(final String descriptor) {
        if (descriptor == null || descriptor.isEmpty()) {
            return;
        }

        if (descriptor.startsWith("(")) {
            // È un descrittore di metodo, rimuovi i tipi di argomento
            int endIndex = descriptor.indexOf(')');
            if (endIndex == -1) {
                return;
            }
            String argsDescriptor = descriptor.substring(1, endIndex);
            removeTypesFromStack(argsDescriptor);
        } else {
            // È un singolo tipo, rimuovi solo quel tipo
            removeTypeFromStack(descriptor);
        }
    }

    private void removeTypesFromStack(String argsDescriptor) {
        int index = 0;
        while (index < argsDescriptor.length()) {
            char currentChar = argsDescriptor.charAt(index);
            if (currentChar == 'L') {
                // Tipo oggetto, trova il ';'
                int endIndex = argsDescriptor.indexOf(';', index);
                if (endIndex == -1) {
                    break;
                }
                String type = argsDescriptor.substring(index, endIndex + 1);
                removeTypeFromStack(type);
                index = endIndex + 1;
            } else if (currentChar == '[') {
                // Tipo array, trova il tipo base
                index++;
            } else {
                // Tipo primitivo
                removeTypeFromStack(String.valueOf(currentChar));
                index++;
            }
        }
    }

    private void removeTypeFromStack(String type) {
        if (!outputStack.isEmpty() && outputStack.peek().equals(type)) {
            outputStack.pop();
        }
    }

    // Metodo di esempio per testare la funzionalità
    public static void main(String[] args) {
        FrameStack frameStack = new FrameStack();
        frameStack.outputStack.push("I");
        frameStack.outputStack.push("Ljava/lang/String;");
        frameStack.outputStack.push("D");

        System.out.println("Stack prima di pop: " + frameStack.outputStack);
        frameStack.pop("(ILjava/lang/String;D)V");
        System.out.println("Stack dopo pop: " + frameStack.outputStack);
    }
}