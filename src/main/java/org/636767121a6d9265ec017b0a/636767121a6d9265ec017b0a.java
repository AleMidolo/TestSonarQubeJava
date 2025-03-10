private int parseEndOfLine(String headerPart, int end) {
    int index = 0;
    while (index < end) {
        char currentChar = headerPart.charAt(index);
        if (currentChar == '\r' && index + 1 < end && headerPart.charAt(index + 1) == '\n') {
            return index;
        }
        index++;
    }
    return -1; // Se non viene trovata la sequenza \r\n
}