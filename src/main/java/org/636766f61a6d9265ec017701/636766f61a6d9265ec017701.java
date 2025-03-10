/**
 * एक स्ट्रिंग के भीतर अंतिम अनुक्रमांक खोजता है, <code>null</code> को संभालते हुए। यह विधि {@link String#lastIndexOf(String)} का उपयोग करती है।
 * 
 * @param str वह स्ट्रिंग जिसमें खोज करनी है, यह <code>null</code> हो सकती है।
 * @param searchStr वह स्ट्रिंग जिसे खोजना है, यह <code>null</code> हो सकती है।
 * @return अंतिम अनुक्रमांक, या <code>-1</code> यदि स्ट्रिंग या खोज स्ट्रिंग <code>null</code> है।
 */
public static int lastIndexOf(String str, String searchStr) {
    if (str == null || searchStr == null) {
        return -1;
    }
    return str.lastIndexOf(searchStr);
}