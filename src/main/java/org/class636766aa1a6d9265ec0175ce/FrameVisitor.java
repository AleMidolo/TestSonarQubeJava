package org.class636766aa1a6d9265ec0175ce;

public class FrameVisitor {

    private int currentFrame;
    private int[] localVariables;
    private int[] stack;

    /**
     * Inizia la visita di un nuovo frame della mappa dello stack, memorizzato in {@link #currentFrame}.
     * @param offset   l'offset del bytecode dell'istruzione a cui corrisponde il frame.
     * @param numLocal il numero di variabili locali nel frame.
     * @param numStack il numero di elementi nello stack nel frame.
     * @return l'indice del prossimo elemento da scrivere in questo frame.
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        this.currentFrame = offset;
        this.localVariables = new int[numLocal];
        this.stack = new int[numStack];
        return 0; // Indice del prossimo elemento da scrivere
    }

    public static void main(String[] args) {
        FrameVisitor visitor = new FrameVisitor();
        int nextIndex = visitor.visitFrameStart(10, 5, 3);
        System.out.println("Next index to write: " + nextIndex);
    }
}