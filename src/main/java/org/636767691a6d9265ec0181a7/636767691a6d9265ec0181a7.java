import java.util.Objects;

public class StringUtils {
  
  /**
  * Trim all occurrences of the supplied leading character from the given String.
  * @param str the String to check
  * @param leadingCharacter the leading character to be trimmed
  * @return the trimmed String
  */
  public static String trimLeadingCharacter(String str, char leadingCharacter) {
  if (str == null) {
  return null;
  }
  
  int len = str.length();
  int start = 0;
  
  while (start < len && str.charAt(start) == leadingCharacter) {
  start++;
  }
  
  return start > 0 ? str.substring(start) : str;
  }
}