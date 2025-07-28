import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TypeResolver {

    /**
     * Risolve il primo vincolo per il {@code typeVariable}, restituendo {@code Unknown.class} se non può essere risolto.
     */
    public static Type resolveBound(TypeVariable<?> typeVariable) {
        if (typeVariable == null) {
            return Unknown.class;
        }

        Type[] bounds = typeVariable.getBounds();
        if (bounds.length == 0) {
            return Unknown.class;
        }

        return bounds[0];
    }

    public static class Unknown {
        // Classe segnaposto per rappresentare un tipo sconosciuto
    }

    public static void main(String[] args) {
        // Esempio di utilizzo
        TypeVariable<?> typeVar = String.class.getTypeParameters()[0];
        Type resolvedType = resolveBound(typeVar);
        System.out.println("Resolved Type: " + resolvedType);
    }
}