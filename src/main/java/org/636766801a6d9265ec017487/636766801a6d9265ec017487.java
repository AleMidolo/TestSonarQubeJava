import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class TemplateEncoder {
    
    /** 
     * Encodes a string with template parameters names present, specifically the characters '{' and '}' will be percent-encoded.
     * @param s the string with zero or more template parameters names
     * @return the string with encoded template parameters names.
     */
    public static String encodeTemplateNames(String s) {
        if (s == null) {
            return null;
        }
        try {
            // Encode the string using UTF-8 and replace the encoded characters for '{' and '}'
            String encoded = URLEncoder.encode(s, "UTF-8");
            return encoded.replace("+", "%20").replace("%7B", "{").replace("%7D", "}");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 encoding not supported", e);
        }
    }

    public static void main(String[] args) {
        String input = "Hello {name}, welcome to {place}!";
        String encoded = encodeTemplateNames(input);
        System.out.println(encoded);
    }
}