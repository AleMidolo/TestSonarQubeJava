public class FilePathSeparator {

    /** 
     * अंतिम निर्देशिका विभाजक वर्ण का अनुक्रमांक लौटाता है। <p> यह विधि फ़ाइल को यूनिक्स या विंडोज़ प्रारूप में संभालेगी। अंतिम फॉरवर्ड या बैकस्लैश की स्थिति लौटाई जाती है। <p> आउटपुट उस मशीन के अनुसार समान होगा जिस पर कोड चल रहा है।
     * @param filename  वह फ़ाइल नाम जिसमें अंतिम पथ विभाजक को खोजना है, null होने पर -1 लौटाता है
     * @return अंतिम विभाजक वर्ण का अनुक्रमांक, या -1 यदि ऐसा कोई वर्ण नहीं है
     */
    public static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }
        
        int lastForwardSlash = filename.lastIndexOf('/');
        int lastBackSlash = filename.lastIndexOf('\\');
        
        return Math.max(lastForwardSlash, lastBackSlash);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(indexOfLastSeparator("C:\\Users\\User\\Documents\\file.txt")); // Output: 20
        System.out.println(indexOfLastSeparator("/home/user/documents/file.txt")); // Output: 15
        System.out.println(indexOfLastSeparator("file.txt")); // Output: -1
        System.out.println(indexOfLastSeparator(null)); // Output: -1
    }
}