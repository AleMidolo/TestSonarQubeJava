import java.util.List;

public class StackMapTableHandler {
    private List<Object> currentFrame;
    private List<Object> stackMapTableEntries;

    /**
     * {@link #currentFrame} के कुछ अमूर्त प्रकारों को {@link #stackMapTableEntries} में डालता है, StackMapTable गुणों में प्रयुक्त JVMS verification_type_info प्रारूप का उपयोग करते हुए।
     * @param start {@link #currentFrame} में लिखने के लिए पहले प्रकार का अनुक्रमांक।
     * @param end {@link #currentFrame} में लिखने के लिए अंतिम प्रकार का अनुक्रमांक (असामान्य)।
     */
    private void putAbstractTypes(final int start, final int end) {
        if (start < 0 || end > currentFrame.size() || start > end) {
            throw new IllegalArgumentException("Invalid start or end index");
        }

        for (int i = start; i < end; i++) {
            Object type = currentFrame.get(i);
            stackMapTableEntries.add(type);
        }
    }
}