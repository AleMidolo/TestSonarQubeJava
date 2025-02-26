import java.io.File;

public class FileUtils {

    /** 
     * यदि निर्दिष्ट फ़ाइल मौजूद है, तो उसे हटाएं 
     */
    protected static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully: " + fileName);
            } else {
                System.out.println("Failed to delete the file: " + fileName);
            }
        } else {
            System.out.println("File does not exist: " + fileName);
        }
    }

    public static void main(String[] args) {
        // Example usage
        deleteFile("example.txt");
    }
}