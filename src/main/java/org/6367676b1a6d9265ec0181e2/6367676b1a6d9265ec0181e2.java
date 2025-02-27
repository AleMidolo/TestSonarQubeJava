import java.util.Collection;

public class MatchFinder {
    /** 
     * Devuelve el primer elemento en '<code>candidates</code>' que se encuentra en '<code>source</code>'. 
     * Si no hay ningún elemento en '<code>candidates</code>' presente en '<code>source</code>', 
     * devuelve <code>null</code>. El orden de iteración es específico de la implementación de {@link Collection}.
     * @param source la colección fuente
     * @param candidates los candidatos a buscar
     * @return el primer objeto presente, o <code>null</code> si no se encuentra
     */
    public static Object findFirstMatch(Collection source, Collection candidates) {
        for (Object candidate : candidates) {
            if (source.contains(candidate)) {
                return candidate;
            }
        }
        return null;
    }
}