import java.util.Arrays;

public class StringArrayUtil {
    /** 
     * दिए गए स्ट्रिंग को दिए गए स्ट्रिंग एरे में जोड़ें, एक नया एरे लौटाते हुए जिसमें इनपुट एरे की सामग्री और दिया गया स्ट्रिंग शामिल हो।
     * @param array वह एरे जिसमें जोड़ना है (यह <code>null</code> हो सकता है)
     * @param str वह स्ट्रिंग जिसे जोड़ना है
     * @return नया एरे (कभी भी <code>null</code> नहीं)
     */
    public static String[] addStringToArray(String[] array, String str) {
        if (array == null) {
            return new String[] { str };
        }
        
        String[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[array.length] = str;
        return newArray;
    }
}