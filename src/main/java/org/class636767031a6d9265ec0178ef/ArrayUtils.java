package org.class636767031a6d9265ec0178ef;

import java.lang.reflect.Array;

public class ArrayUtils {

    /** 
     * Restituisce una copia dell'array fornito di dimensione 1 maggiore rispetto all'argomento. L'ultimo valore dell'array viene lasciato al valore predefinito.
     * @param array L'array da copiare, non deve essere <code>null</code>.
     * @param newArrayComponentType Se <code>array</code> è <code>null</code>, crea un array di dimensione 1 di questo tipo.
     * @return Una nuova copia dell'array di dimensione 1 maggiore rispetto all'input.
     */
    private static Object copyArrayGrow1(final Object array, final Class<?> newArrayComponentType) {
        if (array == null) {
            return Array.newInstance(newArrayComponentType, 1);
        }
        
        int length = Array.getLength(array);
        Object newArray = Array.newInstance(array.getClass().getComponentType(), length + 1);
        
        for (int i = 0; i < length; i++) {
            Array.set(newArray, i, Array.get(array, i));
        }
        
        return newArray;
    }
}