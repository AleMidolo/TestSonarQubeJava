/**
 * <p>जांचता है कि क्या वर्ण ASCII 7 बिट वर्णमाला के बड़े अक्षर हैं।</p> 
 * <pre> 
 * CharUtils.isAsciiAlphaUpper('a')  = false 
 * CharUtils.isAsciiAlphaUpper('A')  = true 
 * CharUtils.isAsciiAlphaUpper('3')  = false 
 * CharUtils.isAsciiAlphaUpper('-')  = false 
 * CharUtils.isAsciiAlphaUpper('\n') = false 
 * CharUtils.isAsciiAlphaUpper('&copy;') = false 
 * </pre>
 * @param ch  जांचने के लिए वर्ण
 * @return 65 और 90 के बीच (समावेशी) होने पर true
 */
public class CharUtils {
    public static boolean isAsciiAlphaUpper(final char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
}