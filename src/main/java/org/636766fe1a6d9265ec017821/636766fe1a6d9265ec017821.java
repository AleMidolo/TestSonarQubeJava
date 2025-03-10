import java.util.Arrays;

/**
 * <p><code>toString</code> में <code>byte</code> ऐरे का विवरण जोड़ें।</p>
 * @param buffer  वह <code>StringBuffer</code> जिसे भरना है
 * @param fieldName  फ़ील्ड का नाम, आमतौर पर इसका उपयोग नहीं किया जाता क्योंकि यह पहले से ही जोड़ा गया है
 * @param array  वह ऐरे जिसे <code>toString</code> में जोड़ना है, <code>null</code> नहीं होना चाहिए
 */
protected void appendDetail(StringBuffer buffer, String fieldName, byte[] array) {
    if (array == null) {
        throw new IllegalArgumentException("Array cannot be null");
    }
    buffer.append(Arrays.toString(array));
}