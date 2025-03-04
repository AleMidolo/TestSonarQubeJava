import java.util.Objects;

public class StringUtils {

    /**
     * <p>Verifica si una cadena comienza con un prefijo especificado (opcionalmente sin distinguir entre mayúsculas y minúsculas).</p>
     * @see String#startsWith(String)
     * @param str  la cadena a verificar, puede ser nula
     * @param prefix el prefijo a encontrar, puede ser nulo
     * @param ignoreCase indica si la comparación debe ignorar las mayúsculas y minúsculas (sin distinguir entre mayúsculas y minúsculas) o no.
     * @return <code>true</code> si la cadena comienza con el prefijo o ambos son <code>null</code>
     */
    private static boolean startsWith(final String str, final String prefix, final boolean ignoreCase) {
        if (str == null && prefix == null) {
            return true;
        }
        if (str == null || prefix == null) {
            return false;
        }
        if (prefix.length() > str.length()) {
            return false;
        }
        
        if (ignoreCase) {
            return str.regionMatches(true, 0, prefix, 0, prefix.length());
        }
        return str.startsWith(prefix);
    }
}