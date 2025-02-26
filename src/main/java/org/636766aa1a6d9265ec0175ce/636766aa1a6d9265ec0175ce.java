public class FrameVisitor {
    private int currentFrame;

    /**
     * Inizia la visita di un nuovo frame della mappa dello stack, memorizzato in {@link #currentFrame}.
     * @param offset   l'offset del bytecode dell'istruzione a cui corrisponde il frame.
     * @param numLocal il numero di variabili locali nel frame.
     * @param numStack il numero di elementi nello stack nel frame.
     * @return l'indice del prossimo elemento da scrivere in questo frame.
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        // Logica per iniziare la visita del frame
        currentFrame = offset; // Memorizza l'offset nel frame corrente
        // Potresti voler gestire numLocal e numStack qui, ad esempio:
        // inizializza le variabili locali e lo stack in base a numLocal e numStack

        // Restituisce l'indice del prossimo elemento da scrivere
        return numLocal + numStack; // Esempio di calcolo dell'indice
    }

    public static void main(String[] args) {
        FrameVisitor visitor = new FrameVisitor();
        int nextIndex = visitor.visitFrameStart(10, 5, 3);
        System.out.println("Next index to write: " + nextIndex);
    }
}