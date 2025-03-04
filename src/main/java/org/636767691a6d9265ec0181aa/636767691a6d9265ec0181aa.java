package org.utils;

public class ArrayHashCodeUtils {
    /**
     * Devuelve un código hash basado en el contenido del array especificado. Si el <code>array</code> es <code>null</code>, este método devuelve 0.
     * @param array el array de tipo long para obtener un código hash
     * @return el código hash del array de tipo long, que podría ser 0 si el array es null.
     */
    public static int nullSafeHashCode(long[] array) {
        if (array == null) {
            return 0;
        }
        
        int hash = 1;
        for (long element : array) {
            hash = 31 * hash + (int)(element ^ (element >>> 32));
        }
        return hash;
    }
}