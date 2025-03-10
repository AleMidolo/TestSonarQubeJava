import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class FileHandler {

    /**
     * 以逆序添加指定的文件。
     */
    private void addReverse(final File[] files) {
        if (files == null) {
            return;
        }

        List<File> fileList = new ArrayList<>();
        for (File file : files) {
            if (file != null) {
                fileList.add(file);
            }
        }

        Collections.reverse(fileList);

        // Assuming you want to do something with the reversed list, like adding to another list or processing
        // For example, printing the file names in reverse order
        for (File file : fileList) {
            System.out.println(file.getName());
        }
    }
}