package org.class6367676b1a6d9265ec0181e2;

import java.util.Collection;

public class MatchFinder {
    /** 
     * Restituisce il primo elemento in '<code>candidates</code>' che è contenuto in '<code>source</code>'. Se nessun elemento in '<code>candidates</code>' è presente in '<code>source</code>', restituisce <code>null</code>. L'ordine di iterazione è specifico dell'implementazione di {@link Collection}.
     * @param source la Collection sorgente
     * @param candidates i candidati da cercare
     * @return il primo oggetto presente, oppure <code>null</code> se non trovato
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