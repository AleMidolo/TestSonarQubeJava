import java.util.HashSet;
import java.util.Set;

public class StringManipulator {

    /** 
     * Delete any character in a given String.
     * @param inString the original String
     * @param charsToDelete a set of characters to delete.E.g. "az\n" will delete 'a's, 'z's and new lines.
     * @return the resulting String
     */
    public static String deleteAny(String inString, String charsToDelete) {
        Set<Character> charsToDeleteSet = new HashSet<>();
        for (char c : charsToDelete.toCharArray()) {
            charsToDeleteSet.add(c);
        }

        StringBuilder result = new StringBuilder();
        for (char c : inString.toCharArray()) {
            if (!charsToDeleteSet.contains(c)) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String original = "Hello World! This is a test string.";
        String charsToRemove = "aeiou";
        String result = deleteAny(original, charsToRemove);
        System.out.println(result); // Hll Wrld! Ths s  tst strng.
    }
}