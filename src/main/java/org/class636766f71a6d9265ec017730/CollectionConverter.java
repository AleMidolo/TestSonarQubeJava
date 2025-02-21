package org.class636766f71a6d9265ec017730;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionConverter {

    /** 
     * Converte la Collection fornita in un array di Stringhe. L'array restituito non contiene elementi <code>null</code>. Si noti che {@link Arrays#sort(Object[])} genererà un {@link NullPointerException} se un elemento dell'array è <code>null</code>.
     * @param collection La collezione da convertire
     * @return Un nuovo array di Stringhe.
     */
    static String[] toNoNullStringArray(Collection<?> collection) {
        if (collection == null) {
            return new String[0];
        }
        
        ArrayList<String> stringList = new ArrayList<>();
        for (Object obj : collection) {
            if (obj != null) {
                stringList.add(obj.toString());
            }
        }
        
        return stringList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Example usage
        Collection<Object> collection = new ArrayList<>();
        collection.add("Hello");
        collection.add(null);
        collection.add("World");
        
        String[] result = toNoNullStringArray(collection);
        for (String str : result) {
            System.out.println(str);
        }
    }
}