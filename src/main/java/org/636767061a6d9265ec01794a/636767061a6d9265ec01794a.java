import java.util.Objects;

public class FileUtils {

    /**
     * Returns the index of the last extension separator character, which is a dot. <p> This method also checks that there is no directory separator after the last dot. To do this it uses  {@link #indexOfLastSeparator(String)} which will handle a file in either Unix or Windows format. <p> The output will be the same irrespective of the machine that the code is running on.
     * @param filename  the filename to find the last path separator in, null returns -1
     * @return the index of the last separator character, or -1 if there is no such character
     */
    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }

        int lastSeparatorIndex = indexOfLastSeparator(filename);
        int extensionIndex = filename.lastIndexOf('.');

        if (lastSeparatorIndex > extensionIndex) {
            return -1;
        }

        return extensionIndex;
    }

    /**
     * Returns the index of the last directory separator character.
     * @param filename  the filename to find the last path separator in, null returns -1
     * @return the index of the last separator character, or -1 if there is no such character
     */
    private static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }

        int lastUnixPos = filename.lastIndexOf('/');
        int lastWindowsPos = filename.lastIndexOf('\\');

        return Math.max(lastUnixPos, lastWindowsPos);
    }

    public static void main(String[] args) {
        System.out.println(indexOfExtension("example/file.txt")); // Output: 13
        System.out.println(indexOfExtension("example/file"));    // Output: -1
        System.out.println(indexOfExtension("example/file."));    // Output: 13
        System.out.println(indexOfExtension("example/file.txt.gz")); // Output: 17
        System.out.println(indexOfExtension(null));              // Output: -1
    }
}