package org.apache.commons.io;

public class FilenameUtils {

    private static final char EXTENSION_SEPARATOR = '.';
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }

        // Get the last directory separator position
        int lastDirSeparator = indexOfLastSeparator(filename);
        
        // Find last dot in filename
        int lastDotPos = filename.lastIndexOf(EXTENSION_SEPARATOR);
        
        // Return -1 if:
        // - No dot found
        // - Dot is first char
        // - Dot comes before last directory separator
        // - Dot is last char
        if (lastDotPos == -1 || 
            lastDotPos == 0 ||
            lastDotPos < lastDirSeparator ||
            lastDotPos == filename.length() - 1) {
            return -1;
        }
        
        return lastDotPos;
    }

    public static int indexOfLastSeparator(String filename) {
        if (filename == null) {
            return -1;
        }
        
        int lastUnixPos = filename.lastIndexOf(UNIX_SEPARATOR);
        int lastWindowsPos = filename.lastIndexOf(WINDOWS_SEPARATOR);
        return Math.max(lastUnixPos, lastWindowsPos);
    }
}