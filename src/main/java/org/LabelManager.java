package org;

import java.util.Objects;

public class LabelManager {
    static class Label {
        private final int offset;

        public Label(int offset) {
            this.offset = offset;
        }

        public int getOffset() {
            return offset;
        }
    }

    /**
     * Restituisce l'etichetta corrispondente all'offset di bytecode fornito. 
     * L'implementazione predefinita di questo metodo crea un'etichetta per l'offset dato se non è già stata creata.
     * @param bytecodeOffset un offset di bytecode in un metodo.
     * @param labels le etichette già create, indicizzate per il loro offset. 
     * Se un'etichetta esiste già per bytecodeOffset, questo metodo non deve crearne una nuova. 
     * Altrimenti, deve memorizzare la nuova etichetta in questo array.
     * @return un'etichetta non nulla, che deve essere uguale a labels[bytecodeOffset].
     */
    protected Label readLabel(final int bytecodeOffset, final Label[] labels) {
        if (labels[bytecodeOffset] != null) {
            return labels[bytecodeOffset];
        }
        Label newLabel = new Label(bytecodeOffset);
        labels[bytecodeOffset] = newLabel;
        return newLabel;
    }

    public static void main(String[] args) {
        Label[] labels = new Label[10]; // Example size
        LabelManager manager = new LabelManager();
        
        // Test the readLabel method
        Label label1 = manager.readLabel(2, labels);
        System.out.println("Label at offset 2: " + label1.getOffset());
        
        Label label2 = manager.readLabel(2, labels);
        System.out.println("Label at offset 2 again: " + label2.getOffset());
        
        Label label3 = manager.readLabel(3, labels);
        System.out.println("Label at offset 3: " + label3.getOffset());
    }
}