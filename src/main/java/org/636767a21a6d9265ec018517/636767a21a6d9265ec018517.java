import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class Buffer {

    private ByteArrayOutputStream buffer;

    public Buffer() {
        this.buffer = new ByteArrayOutputStream();
    }

    public void write(byte[] data) {
        try {
            buffer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Devuelve un único array de bytes que contiene todos los contenidos escritos en el/los buffer(s).
     */
    public final byte[] toByteArray() {
        return buffer.toByteArray();
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        buffer.write(new byte[]{1, 2, 3});
        buffer.write(new byte[]{4, 5, 6});
        byte[] result = buffer.toByteArray();
        for (byte b : result) {
            System.out.print(b + " ");
        }
    }
}