import java.util.ArrayList;
import java.util.List;

public class ByteVector {
    private List<Byte> bytes;

    public ByteVector() {
        this.bytes = new ArrayList<>();
    }

    /**
     * 将两个字节放入此字节向量。如有必要，字节向量会自动扩展。
     * @param byteValue1 一个字节。
     * @param byteValue2 另一个字节。
     * @return 此字节向量。
     */
    public final ByteVector put11(final int byteValue1, final int byteValue2) {
        bytes.add((byte) byteValue1);
        bytes.add((byte) byteValue2);
        return this;
    }

    // 其他方法可以根据需要添加
}