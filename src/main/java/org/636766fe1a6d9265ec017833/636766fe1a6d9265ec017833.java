import java.io.File;
import java.io.IOException;

public class FileUtils {

    /**
     * Pianifica la cancellazione di un file quando la JVM termina. Se il file è una directory, cancella lei e tutte le sottodirectory.
     * @param file  file o directory da cancellare, non deve essere {@code null}
     * @throws NullPointerException se il file è {@code null}
     * @throws IOException in caso di cancellazione non riuscita
     */
    public static void forceDeleteOnExit(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }

        file.deleteOnExit();

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    forceDeleteOnExit(subFile);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("path/to/your/file_or_directory");
            forceDeleteOnExit(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}