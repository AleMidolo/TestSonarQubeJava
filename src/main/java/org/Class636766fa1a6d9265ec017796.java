package org;

public class Class636766fa1a6d9265ec017796 {

    /** 
     * <p>Converte un array di booleani primitivi in oggetti.</p> <p>Questo metodo restituisce <code>null</code> per un array di input <code>null</code>.</p>
     * @param array  un array di <code>boolean</code>
     * @return un array di <code>Boolean</code>, <code>null</code> se l'array di input è null
     */
    public static Boolean[] toObject(final boolean[] array) {
        if (array == null) {
            return null;
        }
        Boolean[] result = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Boolean.valueOf(array[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        boolean[] primitiveArray = {true, false, true};
        Boolean[] objectArray = toObject(primitiveArray);
        for (Boolean b : objectArray) {
            System.out.println(b);
        }
    }
}