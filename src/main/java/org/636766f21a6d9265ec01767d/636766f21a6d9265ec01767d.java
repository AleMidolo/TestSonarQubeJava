public class ObjectToStringUtil {

    /**
     * Converts an object to its string representation. If the object is null, returns null.
     * Otherwise, returns the result of the object's toString() method.
     *
     * @param object the object to convert to a string
     * @return the string representation of the object, or null if the object is null
     */
    public static String toString(Object object) {
        if (object == null) {
            return null;
        }
        return object.toString();
    }

    public static void main(String[] args) {
        // Example usage
        Object obj1 = null;
        Object obj2 = "Hello, World!";
        Object obj3 = 12345;

        System.out.println(toString(obj1)); // Output: null
        System.out.println(toString(obj2)); // Output: Hello, World!
        System.out.println(toString(obj3)); // Output: 12345
    }
}