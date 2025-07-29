import java.util.Collection;

public class CollectionUtils {

    /**
     * Controlla se la Collection fornita contiene l'istanza dell'elemento dato.
     * <p>Imporre che l'istanza fornita sia presente, piuttosto che restituire <code>true</code> per un elemento uguale.
     * @param collection la Collection da controllare
     * @param element l'elemento da cercare
     * @return <code>true</code> se trovato, <code>false</code> altrimenti
     */
    public static boolean containsInstance(Collection collection, Object element) {
        if (collection == null || element == null) {
            return false;
        }
        
        for (Object obj : collection) {
            if (obj == element) { // Check reference equality, not equals()
                return true;
            }
        }
        return false;
    }
}