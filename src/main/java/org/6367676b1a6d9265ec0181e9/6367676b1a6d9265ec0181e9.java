public class SubstringMatcher {

    /** 
     * Returns  {@code true} if the given string matches the given substring at the given index, {@code false} otherwise.
     * @param str the original string (or StringBuilder)
     * @param index the index in the original string to start matching against
     * @param substring the substring to match at the given index
     * @return {@code true} if the given string matches the given substring at the given index, {@code false} otherwise.
     */
    public static boolean substringMatch(CharSequence str, int index, CharSequence substring) {
        if (str == null || substring == null) {
            return false;
        }
        if (index < 0 || index + substring.length() > str.length()) {
            return false;
        }
        for (int i = 0; i < substring.length(); i++) {
            if (str.charAt(index + i) != substring.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Example usage
        String original = "Hello, World!";
        String sub = "World";
        boolean result = substringMatch(original, 7, sub);
        System.out.println(result); // Output: true
    }
}