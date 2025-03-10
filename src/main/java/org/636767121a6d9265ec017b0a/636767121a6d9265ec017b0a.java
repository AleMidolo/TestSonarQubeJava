private int parseEndOfLine(String headerPart, int end) {
    int index = end;
    while (index < headerPart.length()) {
        char currentChar = headerPart.charAt(index);
        if (currentChar == '\r' && index + 1 < headerPart.length() && headerPart.charAt(index + 1) == '\n') {
            return index; // Return the index of the '\r\n' sequence
        }
        index++;
    }
    return -1; // Return -1 if no '\r\n' sequence is found
}