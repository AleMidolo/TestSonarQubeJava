import java.util.Objects;

public class ToStringBuilder {

    /**
     * <p>Append to the <code>toString</code> the detail of a <code>byte</code> array.</p>
     * @param buffer  the <code>StringBuffer</code> to populate
     * @param fieldName  the field name, typically not used as already appended
     * @param array  the array to add to the <code>toString</code>, not <code>null</code>
     */
    protected void appendDetail(StringBuffer buffer, String fieldName, byte[] array) {
        Objects.requireNonNull(array, "The byte array must not be null");

        buffer.append('[');
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            buffer.append(array[i]);
        }
        buffer.append(']');
    }
}