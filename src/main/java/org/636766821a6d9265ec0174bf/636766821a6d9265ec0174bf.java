import java.beans.Introspector;

public class StringUtils {

  /**
  * Reverse of Introspector.decapitalize
  * Capitalizes the first letter of a string, making the first letter uppercase.
  * If the second letter is uppercase, the first letter remains lowercase.
  * @param name The string to capitalize
  * @return The capitalized string
  */
  public static String capitalize(String name) {
  if (name == null || name.length() == 0) {
  return name;
  }
  if (name.length() > 1 && Character.isUpperCase(name.charAt(1))) {
  return name;
  }
  char chars[] = name.toCharArray();
  chars[0] = Character.toUpperCase(chars[0]);
  return new String(chars);
  }
}