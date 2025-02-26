import java.util.Arrays;

public class ByteArrayEnlarger {
    private byte[] byteArray;

    public ByteArrayEnlarger(int initialSize) {
        this.byteArray = new byte[initialSize];
    }

    /**
     * Aumenta la taglia di questo vettore di byte in modo che possa ricevere 'size' byte aggiuntivi.
     * @param size numero di byte aggiuntivi che questo vettore di byte dovrebbe essere in grado di ricevere.
     */
    private void enlarge(final int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be non-negative");
        }
        int newSize = byteArray.length + size;
        byteArray = Arrays.copyOf(byteArray, newSize);
    }

    public byte[] getByteArray() {
        return byteArray;
    }

    public static void main(String[] args) {
        ByteArrayEnlarger enlarger = new ByteArrayEnlarger(5);
        System.out.println("Initial size: " + enlarger.getByteArray().length);
        enlarger.enlarge(10);
        System.out.println("New size: " + enlarger.getByteArray().length);
    }
}