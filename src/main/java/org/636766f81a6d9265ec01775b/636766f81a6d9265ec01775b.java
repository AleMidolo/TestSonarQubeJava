import java.nio.ByteBuffer;

public class ClassReader {
    private byte[] data;

    public ClassReader(byte[] data) {
        this.data = data;
    }

    /**
     * इस {@link ClassReader} में एक साइन किया हुआ लॉन्ग मान पढ़ता है। <i>यह विधि {@link Attribute} उप श्रेणियों के लिए अभिप्रेत है, और सामान्यतः क्लास जनरेटर या एडाप्टर द्वारा आवश्यक नहीं होती।</i>
     * @param offset इस {@link ClassReader} में पढ़े जाने वाले मान का प्रारंभिक ऑफसेट।
     * @return पढ़ा गया मान।
     */
    public long readLong(final int offset) {
        if (offset < 0 || offset + 8 > data.length) {
            throw new IndexOutOfBoundsException("Invalid offset or insufficient data to read a long value.");
        }
        ByteBuffer buffer = ByteBuffer.wrap(data, offset, 8);
        return buffer.getLong();
    }
}