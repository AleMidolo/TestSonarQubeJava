import java.util.Objects;

public class BooleanUtils {

  public static Boolean[] toObject(boolean[] array) {
  if (array == null) {
  return null;
  }
  
  Boolean[] result = new Boolean[array.length];
  for (int i = 0; i < array.length; i++) {
  result[i] = Boolean.valueOf(array[i]);
  }
  return result;
  }
}