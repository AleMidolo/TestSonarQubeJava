public class FrameVisitor {
    private Frame currentFrame;

    public FrameVisitor(Frame currentFrame) {
        this.currentFrame = currentFrame;
    }

    /**
     * Inicia la visita de un nuevo "stack map frame", almacenado en {@link #currentFrame}.
     * @param offset   el desplazamiento de bytecode de la instrucción a la que corresponde el "frame".
     * @param numLocal el número de variables locales en el "frame".
     * @param numStack el número de elementos apilados en el "frame".
     * @return el índice del siguiente elemento que se escribirá en este "frame".
     */
    public int visitFrameStart(final int offset, final int numLocal, final int numStack) {
        currentFrame = new Frame(offset, numLocal, numStack);
        return currentFrame.getNextIndex();
    }

    private static class Frame {
        private final int offset;
        private final int numLocal;
        private final int numStack;
        private int nextIndex;

        public Frame(int offset, int numLocal, int numStack) {
            this.offset = offset;
            this.numLocal = numLocal;
            this.numStack = numStack;
            this.nextIndex = 0; // Inicializa el índice del siguiente elemento a 0
        }

        public int getNextIndex() {
            return nextIndex++;
        }
    }
}