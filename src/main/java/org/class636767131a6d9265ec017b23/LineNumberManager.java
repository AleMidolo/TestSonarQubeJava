package org.class636767131a6d9265ec017b23;

public class LineNumberManager {
    private int lineNumber;

    /** 
     * Aggiunge un numero di riga sorgente corrispondente a questa etichetta.
     * @param lineNumber un numero di riga sorgente (che dovrebbe essere strettamente positivo).
     */
    final void addLineNumber(final int lineNumber) {
        if (lineNumber <= 0) {
            throw new IllegalArgumentException("Il numero di riga deve essere strettamente positivo.");
        }
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public static void main(String[] args) {
        LineNumberManager manager = new LineNumberManager();
        manager.addLineNumber(5);
        System.out.println("Numero di riga aggiunto: " + manager.getLineNumber());
    }
}