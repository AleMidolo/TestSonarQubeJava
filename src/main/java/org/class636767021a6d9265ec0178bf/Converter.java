package org.class636767021a6d9265ec0178bf;

import java.lang.Character;

public class Converter {

    /**
     * <p>Converte l'oggetto di input in un java.lang.Character.</p>
     * @param type Il tipo di dato in cui questo valore dovrebbe essere convertito.
     * @param value Il valore di input da convertire.
     * @return Il valore convertito.
     * @throws Exception se la conversione non può essere eseguita con successo
     * @since 1.8.0
     */
    @Override
    protected Object convertToType(final Class<?> type, final Object value) throws Exception {
        if (type == Character.class) {
            if (value instanceof String) {
                String strValue = (String) value;
                if (strValue.length() == 1) {
                    return strValue.charAt(0);
                } else {
                    throw new Exception("String length must be 1 to convert to Character.");
                }
            } else if (value instanceof Character) {
                return value;
            } else {
                throw new Exception("Cannot convert " + value.getClass().getName() + " to Character.");
            }
        }
        throw new Exception("Unsupported type: " + type.getName());
    }
}