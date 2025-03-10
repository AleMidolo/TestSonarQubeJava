import java.util.List;

public class StringUtils {

    /**
     * Case in-sensitive Checks if the String contains any character in the given set of string.
     * 
     * @param str The string to check.
     * @param searchStrArray The list of strings to search for.
     * @return true if the string contains any of the search strings (case insensitive), false otherwise.
     */
    public static boolean containsAnyIgnoreCase(String str, List<String> searchStrArray) {
        if (str == null || searchStrArray == null || searchStrArray.isEmpty()) {
            return false;
        }

        String lowerCaseStr = str.toLowerCase();
        for (String searchStr : searchStrArray) {
            if (searchStr != null && lowerCaseStr.contains(searchStr.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example usage
        List<String> searchStrings = List.of("hello", "world");
        System.out.println(containsAnyIgnoreCase("Hello, World!", searchStrings)); // true
        System.out.println(containsAnyIgnoreCase("Goodbye, World!", searchStrings)); // true
        System.out.println(containsAnyIgnoreCase("Hi there!", searchStrings)); // false
    }
}