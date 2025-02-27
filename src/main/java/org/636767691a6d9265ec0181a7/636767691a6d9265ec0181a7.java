public class StringTrimmer {
    
    /** 
     * Elimina todas las ocurrencias del carácter inicial proporcionado de la cadena dada.
     * @param str la cadena a verificar
     * @param leadingCharacter el carácter inicial que se debe eliminar
     * @return la cadena sin el carácter inicial
     */
    public static String trimLeadingCharacter(String str, char leadingCharacter) {
        if (str == null) {
            return null;
        }
        
        StringBuilder result = new StringBuilder();
        boolean leadingCharFound = false;

        for (char c : str.toCharArray()) {
            if (c == leadingCharacter && !leadingCharFound) {
                // Skip the leading character
                continue;
            } else {
                leadingCharFound = true;
                result.append(c);
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        String testString = "aaabacada";
        char leadingChar = 'a';
        String result = trimLeadingCharacter(testString, leadingChar);
        System.out.println(result); // Output: "bacada"
    }
}