import java.util.Objects;

public class ArrayConverter {
    
    /** 
     * <p>ऑब्जेक्ट डबल्स के एक एरे को प्रिमिटिव्स में परिवर्तित करता है।</p> 
     * <p>यह विधि <code>null</code> इनपुट एरे के लिए <code>null</code> लौटाती है।</p>
     * @param array  एक <code>Double</code> एरे, यह <code>null</code> हो सकता है
     * @return एक <code>double</code> एरे, यदि इनपुट एरे <code>null</code> है तो <code>null</code>
     * @throws NullPointerException यदि एरे की सामग्री <code>null</code> है
     */
    public static double[] toPrimitive(final Double[] array) {
        if (array == null) {
            return null;
        }
        double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("Array element at index " + i + " is null");
            }
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Double[] objectArray = {1.1, 2.2, 3.3};
        double[] primitiveArray = toPrimitive(objectArray);
        for (double d : primitiveArray) {
            System.out.println(d);
        }
    }
}