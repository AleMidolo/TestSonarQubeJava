import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

public class CollectionUtils {

    /**
     * दिए गए संग्रह को स्ट्रिंग्स के एक ऐरे में परिवर्तित करता है। लौटाया गया ऐरे <code>null</code> प्रविष्टियाँ नहीं रखता है। ध्यान दें कि {@link Arrays#sort(Object[])} एक {@link NullPointerException} फेंकेगा यदि ऐरे का कोई तत्व <code>null</code> है।
     * @param collection परिवर्तित करने के लिए संग्रह
     * @return स्ट्रिंग्स का एक नया ऐरे।
     */
    static String[] toNoNullStringArray(Collection<?> collection) {
        if (collection == null) {
            return new String[0];
        }
        
        ArrayList<String> nonNullStrings = new ArrayList<>();
        for (Object obj : collection) {
            if (obj != null) {
                nonNullStrings.add(obj.toString());
            }
        }
        
        return nonNullStrings.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Collection<Object> collection = Arrays.asList("Hello", null, 123, null, "World");
        String[] result = toNoNullStringArray(collection);
        System.out.println(Arrays.toString(result)); // Output: [Hello, 123, World]
    }
}