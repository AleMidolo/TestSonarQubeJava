import java.util.ArrayList;
import java.util.List;

public class ByteVector {
    private List<Byte> bytes;

    public ByteVector() {
        this.bytes = new ArrayList<>();
    }

    /**
     * Coloca dos bytes en este vector de bytes. El vector de bytes se amplía automáticamente si es necesario.
     * @param byteValue1 un byte.
     * @param byteValue2 otro byte.
     * @return este vector de bytes.
     */
    public final ByteVector put11(final int byteValue1, final int byteValue2) {
        bytes.add((byte) byteValue1);
        bytes.add((byte) byteValue2);
        return this;
    }

    public byte[] toByteArray() {
        byte[] result = new byte[bytes.size()];
        for (int i = 0; i < bytes.size(); i++) {
            result[i] = bytes.get(i);
        }
        return result;
    }
}