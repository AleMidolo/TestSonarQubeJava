package org;

public class HeaderParser {

    /** 
     * Salta i byte fino alla fine della riga corrente.
     * @param headerPart Le intestazioni che vengono analizzate.
     * @param end Indice dell'ultimo byte che deve ancora essere elaborato.
     * @return Indice della sequenza \r\n, che indica la fine della riga.
     */
    private int parseEndOfLine(String headerPart, int end) {
        // Ensure we do not go out of bounds
        if (end < 0 || end >= headerPart.length()) {
            return -1; // Invalid index
        }

        // Search for the end of line sequence \r\n
        for (int i = end; i < headerPart.length() - 1; i++) {
            if (headerPart.charAt(i) == '\r' && headerPart.charAt(i + 1) == '\n') {
                return i + 2; // Return the index after \r\n
            }
        }

        // If \r\n is not found, return the length of the string
        return headerPart.length();
    }

    public static void main(String[] args) {
        HeaderParser parser = new HeaderParser();
        String headers = "Header1: value1\r\nHeader2: value2\r\n";
        int endIndex = parser.parseEndOfLine(headers, 0);
        System.out.println("End of line index: " + endIndex);
    }
}