package org.class636767061a6d9265ec01794a;

public class FileExtensionUtil {

    /**
     * Restituisce l'indice dell'ultimo carattere separatore dell'estensione, che è un punto. <p> Questo metodo verifica anche che non ci sia un separatore di directory dopo l'ultimo punto. Per fare ciò, utilizza {@link #indexOfLastSeparator(String)} che gestirà un file sia in formato Unix che Windows. <p> L'output sarà lo stesso indipendentemente dalla macchina su cui il codice viene eseguito.
     * @param filename  il nome del file in cui trovare l'ultimo separatore di percorso, null restituisce -1
     * @return l'indice dell'ultimo carattere separatore, o -1 se non esiste tale carattere
     */
    public static int indexOfExtension(String filename) {
        if (filename == null) {
            return -1;
        }

        int lastSeparatorIndex = indexOfLastSeparator(filename);
        int lastDotIndex = filename.lastIndexOf('.');

        // Verifica che l'ultimo punto non sia dopo l'ultimo separatore
        if (lastDotIndex > lastSeparatorIndex) {
            return lastDotIndex;
        }

        return -1;
    }

    /**
     * Restituisce l'indice dell'ultimo separatore di directory nel nome del file.
     * @param filename il nome del file
     * @return l'indice dell'ultimo separatore di directory, o -1 se non esiste
     */
    private static int indexOfLastSeparator(String filename) {
        int lastUnixSeparator = filename.lastIndexOf('/');
        int lastWindowsSeparator = filename.lastIndexOf('\\');

        return Math.max(lastUnixSeparator, lastWindowsSeparator);
    }

    public static void main(String[] args) {
        // Esempi di utilizzo
        System.out.println(indexOfExtension("document.txt")); // Output: 8
        System.out.println(indexOfExtension("folder/document.txt")); // Output: 8
        System.out.println(indexOfExtension("folder\\document.txt")); // Output: 8
        System.out.println(indexOfExtension("folder\\document")); // Output: -1
        System.out.println(indexOfExtension(null)); // Output: -1
    }
}