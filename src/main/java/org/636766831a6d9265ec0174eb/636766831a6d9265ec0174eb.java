import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileHandler {

    /**
     * Agrega los archivos especificados en orden inverso.
     */
    private void addReverse(final File[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        List<File> fileList = new ArrayList<>();
        
        // Add files to list
        for (File file : files) {
            fileList.add(file);
        }

        // Reverse the list
        Collections.reverse(fileList);

        // Process files in reverse order
        for (File file : fileList) {
            // Add file processing logic here
            processFile(file);
        }
    }

    // Helper method for processing individual files
    private void processFile(File file) {
        // Implementation of file processing
        // This is a placeholder - add actual file handling logic here
        if (file != null && file.exists()) {
            System.out.println("Processing file: " + file.getName());
        }
    }
}