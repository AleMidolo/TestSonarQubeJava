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

        if (file.isDirectory()) {
            deleteDirectoryOnExit(file);
        } else {
            file.deleteOnExit();
        }
    }

    private static void deleteDirectoryOnExit(File directory) throws IOException {
        if (!directory.exists()) {
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            throw new IOException("Failed to list contents of " + directory);
        }

        for (File file : files) {
            if (file.isDirectory()) {
                deleteDirectoryOnExit(file);
            } else {
                file.deleteOnExit();
            }
        }

        directory.deleteOnExit();
    }
}