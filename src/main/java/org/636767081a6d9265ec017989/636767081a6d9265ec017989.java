import java.util.Objects;

public class BooleanArrayConverter {

    /** 
     * <p>Convierte un array de objetos Boolean a primitivos.</p> 
     * <p>Este método devuelve <code>null</code> para un array de entrada <code>null</code>.</p>
     * @param array  un array de <code>Boolean</code>, puede ser <code>null</code>
     * @return un array de <code>boolean</code>, <code>null</code> si el array de entrada es nulo
     * @throws NullPointerException si el contenido del array es <code>null</code>
     */
    public static boolean[] toPrimitive(final Boolean[] array) {
        if (array == null) {
            return null;
        }
        boolean[] primitiveArray = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("El contenido del array no puede ser nulo");
            }
            primitiveArray[i] = array[i];
        }
        return primitiveArray;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Boolean[] booleanArray = {true, false, true};
        boolean[] primitiveArray = toPrimitive(booleanArray);
        for (boolean b : primitiveArray) {
            System.out.println(b);
        }
    }
}