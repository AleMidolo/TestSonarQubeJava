public class ObjectToStringConverter {

    /** 
     * Object to String, when null object then null else return toString(); 
     */
    public static String toString(Object object) {
        return object == null ? null : object.toString();
    }

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = null;

        System.out.println(toString(obj1)); // Prints the object's string representation
        System.out.println(toString(obj2)); // Prints null
    }
}