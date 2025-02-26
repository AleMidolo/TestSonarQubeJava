import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TypeResolver {

    /** 
     * {@code typeVariable} के लिए पहला बाउंड हल करता है, यदि कोई हल नहीं किया जा सकता है तो {@code Unknown.class} लौटाता है।
     */
    public static Type resolveBound(TypeVariable<?> typeVariable) {
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length > 0) {
            return bounds[0];
        }
        return Unknown.class;
    }

    public static class Unknown {}
}