import java.nio.ByteBuffer;

public class ClassReader {
    private ByteBuffer classFileBuffer;
    private char[] charBuffer;
    
    public String readUTF8(final int constantPoolEntryIndex, final char[] charBuffer) {
        int currentIndex = classFileBuffer.position();
        int utfLength = classFileBuffer.getShort(currentIndex) & 0xFFFF;
        
        if (utfLength == 0) {
            return "";
        }
        
        int endIndex = currentIndex + 2 + utfLength;
        int strLength = 0;
        int charIndex = 0;
        
        while (currentIndex < endIndex) {
            int currentByte = classFileBuffer.get(currentIndex + 2) & 0xFF;
            
            if ((currentByte & 0x80) == 0) {
                // Single byte character
                charBuffer[strLength++] = (char) currentByte;
                currentIndex++;
            } else if ((currentByte & 0xE0) == 0xC0) {
                // Two byte character
                charBuffer[strLength++] = (char) (((currentByte & 0x1F) << 6) + 
                    (classFileBuffer.get(currentIndex + 3) & 0x3F));
                currentIndex += 2;
            } else {
                // Three byte character
                charBuffer[strLength++] = (char) (((currentByte & 0xF) << 12) + 
                    ((classFileBuffer.get(currentIndex + 3) & 0x3F) << 6) + 
                    (classFileBuffer.get(currentIndex + 4) & 0x3F));
                currentIndex += 3;
            }
        }
        
        classFileBuffer.position(endIndex);
        return new String(charBuffer, 0, strLength);
    }
}