import java.util.Objects;

public class ArrayUtils {
    
    public static Double[] toObject(final double[] array) {
        if (array == null) {
            return null;
        }
        
        final Double[] result = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Double.valueOf(array[i]);
        }
        return result;
    }
}