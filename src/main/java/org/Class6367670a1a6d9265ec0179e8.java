package org;

public class Class6367670a1a6d9265ec0179e8 {

    private static final Boolean[] EMPTY_BOOLEAN_ARRAY = new Boolean[0];

    /** 
     * <p>Tecnica di programmazione difensiva per cambiare un riferimento <code>null</code> in uno vuoto.</p> 
     * <p>Questo metodo restituisce un array vuoto per un array di input <code>null</code>.</p> 
     * <p>Come tecnica di ottimizzazione della memoria, un array vuoto passato verrà sovrascritto con i riferimenti vuoti <code>public static</code> in questa classe.</p>
     * @param array  l'array da controllare per <code>null</code> o vuoto
     * @return lo stesso array, array vuoto <code>public static</code> se l'input è <code>null</code> o vuoto
     * @since 2.5
     */
    public static Boolean[] nullToEmpty(final Boolean[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        return array;
    }

    public static void main(String[] args) {
        Boolean[] result1 = nullToEmpty(null);
        Boolean[] result2 = nullToEmpty(new Boolean[]{});
        Boolean[] result3 = nullToEmpty(new Boolean[]{true, false});

        System.out.println("Result 1: " + (result1.length == 0)); // Should print true
        System.out.println("Result 2: " + (result2.length == 0)); // Should print true
        System.out.println("Result 3: " + (result3.length == 2)); // Should print true
    }
}