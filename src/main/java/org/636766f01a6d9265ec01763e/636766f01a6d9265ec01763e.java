import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class CharsetTranslator {
  
  /**
  * Translate a MIME standard character set name into the Java equivalent.
  * @param charset The MIME standard name.
  * @return The Java equivalent for this name.
  */
  public static String translateCharset(String charset) {
  if (charset == null || charset.trim().isEmpty()) {
  return Charset.defaultCharset().name();
  }

  Map<String, String> charsetMap = new HashMap<>();
  charsetMap.put("ISO-8859-1", "ISO-8859-1");
  charsetMap.put("ISO8859_1", "ISO-8859-1");
  charsetMap.put("ISO-8859-2", "ISO-8859-2"); 
  charsetMap.put("ISO8859_2", "ISO-8859-2");
  charsetMap.put("UTF-8", "UTF-8");
  charsetMap.put("UTF8", "UTF-8");
  charsetMap.put("US-ASCII", "US-ASCII");
  charsetMap.put("ASCII", "US-ASCII");
  charsetMap.put("windows-1252", "windows-1252");
  charsetMap.put("CP1252", "windows-1252");
  charsetMap.put("windows-1251", "windows-1251");
  charsetMap.put("CP1251", "windows-1251");
  charsetMap.put("SHIFT_JIS", "SHIFT_JIS");
  charsetMap.put("SJIS", "SHIFT_JIS");
  
  String normalizedCharset = charset.trim().toUpperCase();
  String javaCharset = charsetMap.get(normalizedCharset);
  
  if (javaCharset != null) {
  return javaCharset;
  }
  
  // If no mapping found, try to see if Java supports it directly
  try {
  return Charset.forName(charset).name();
  } catch (Exception e) {
  // If charset is not recognized, return default charset
  return Charset.defaultCharset().name();
  }
  }
}