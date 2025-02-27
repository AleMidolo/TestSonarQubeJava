public class ArrayConcatenation {

    /** 
     * Concatenar los arreglos de cadenas dados en uno solo, incluyendo los elementos de los arreglos que se superponen dos veces. 
     * El orden de los elementos en los arreglos originales se preserva.
     * @param array1 el primer arreglo (puede ser <code>null</code>)
     * @param array2 el segundo arreglo (puede ser <code>null</code>)
     * @return el nuevo arreglo (<code>null</code> si ambos arreglos dados eran <code>null</code>)
     */
    public static String[] concatenateStringArrays(String[] array1, String[] array2) {
        if (array1 == null && array2 == null) {
            return null;
        }

        int length1 = (array1 != null) ? array1.length : 0;
        int length2 = (array2 != null) ? array2.length : 0;
        String[] result = new String[length1 + length2];

        int index = 0;
        if (array1 != null) {
            for (String str : array1) {
                result[index++] = str;
            }
        }
        if (array2 != null) {
            for (String str : array2) {
                result[index++] = str;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] array1 = {"Hello", "World"};
        String[] array2 = {"World", "Java"};
        String[] result = concatenateStringArrays(array1, array2);
        
        for (String str : result) {
            System.out.println(str);
        }
    }
}