public class ByteArrayConverter {

    /** 
     * <p>Convierte un arreglo de objetos Byte a primitivos.</p> <p>Este método devuelve <code>null</code> para un arreglo de entrada <code>null</code>.</p>
     * @param array  un arreglo de <code>Byte</code>, puede ser <code>null</code>
     * @return un array de <code>byte</code>, <code>null</code> si el array de entrada es nulo
     * @throws NullPointerException si el contenido del array es <code>null</code>
     */
    public static byte[] toPrimitive(final Byte[] array) {
        if (array == null) {
            return null;
        }
        byte[] result = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("El contenido del array no puede ser nulo");
            }
            result[i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Byte[] byteArray = {1, 2, 3, null}; // Esto lanzará una NullPointerException
        byte[] primitiveArray = toPrimitive(byteArray);
    }
}