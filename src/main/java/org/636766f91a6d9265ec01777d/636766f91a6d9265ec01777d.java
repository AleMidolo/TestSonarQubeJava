public class HexConverter {
  /**
  * @param b An ASCII encoded character 0-9 a-f A-F
  * @return The byte value of the character 0-16.
  */
  public static byte hexCharToByte(char b) {
  if (b >= '0' && b <= '9') {
  return (byte)(b - '0');
  }
  if (b >= 'a' && b <= 'f') {
  return (byte)(b - 'a' + 10);
  }
  if (b >= 'A' && b <= 'F') {
  return (byte)(b - 'A' + 10);
  }
  throw new IllegalArgumentException("Invalid hex character: " + b);
  }
}