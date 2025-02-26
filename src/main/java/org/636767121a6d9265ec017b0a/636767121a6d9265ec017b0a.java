private int parseEndOfLine(String headerPart, int end) {
    // Check if the end index is within the bounds of the string
    if (end < 0 || end >= headerPart.length()) {
        return -1; // Return -1 if the end index is out of bounds
    }

    // Iterate through the string from the end index to find the end of the line
    for (int i = end; i >= 0; i--) {
        // Check for the end of line sequence \r\n
        if (headerPart.charAt(i) == '\n') {
            if (i > 0 && headerPart.charAt(i - 1) == '\r') {
                return i - 1; // Return the index of the \r character
            }
            return i; // Return the index of the \n character
        }
    }

    return -1; // Return -1 if no end of line sequence is found
}