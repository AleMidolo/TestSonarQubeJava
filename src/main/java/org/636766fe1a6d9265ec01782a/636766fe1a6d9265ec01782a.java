public class Utf8Reader {
    private byte[] classFileBuffer;

    public Utf8Reader(byte[] classFileBuffer) {
        this.classFileBuffer = classFileBuffer;
    }

    /**
     * Lee una entrada CONSTANT_Utf8 de un grupo de constantes en {@link #classFileBuffer}.
     * @param constantPoolEntryIndex el índice de una entrada CONSTANT_Utf8 en la tabla de constantes de la clase.
     * @param charBuffer el búfer que se utilizará para leer la cadena. Este búfer debe ser lo suficientemente grande. No se redimensiona automáticamente.
     * @return la cadena correspondiente a la entrada CONSTANT_Utf8 especificada.
     */
    final String readUtf(final int constantPoolEntryIndex, final char[] charBuffer) {
        // Read the length of the UTF-8 string
        int length = ((classFileBuffer[constantPoolEntryIndex] & 0xFF) << 8) | (classFileBuffer[constantPoolEntryIndex + 1] & 0xFF);
        
        // Read the UTF-8 bytes
        for (int i = 0; i < length; i++) {
            charBuffer[i] = (char) (classFileBuffer[constantPoolEntryIndex + 2 + i] & 0xFF);
        }
        
        return new String(charBuffer, 0, length);
    }
}