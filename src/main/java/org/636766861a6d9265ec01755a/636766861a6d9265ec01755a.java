import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class URIMatcher {
    private final Pattern pattern;
    
    public URIMatcher(String uriPattern) {
        this.pattern = Pattern.compile(uriPattern);
    }

    /**
     * Compara una URI con el patrón.
     * @param uri la URI a comparar con la plantilla.
     * @return el resultado de la coincidencia, o null si no hay coincidencia.
     */
    public final MatchResult match(CharSequence uri) {
        if (uri == null) {
            return null;
        }

        Matcher matcher = pattern.matcher(uri);
        if (!matcher.matches()) {
            return null;
        }

        return matcher.toMatchResult();
    }
}