package org;

import java.util.Arrays;

public class ArrayComparer {
    
    /** 
     * Restituisce true se i contenuti dell'array interno e dell'array fornito corrispondono.
     */
    public boolean equals(final byte[] data, int offset, final int len) {
        // Assuming 'this.data' is the internal byte array to compare with
        byte[] internalData = this.data; // Replace with actual internal data initialization
        
        if (offset < 0 || len < 0 || offset + len > data.length || len > internalData.length) {
            return false;
        }
        
        return Arrays.equals(Arrays.copyOfRange(internalData, 0, len), 
                             Arrays.copyOfRange(data, offset, offset + len));
    }
    
    // Placeholder for internal data
    private byte[] data = new byte[] {1, 2, 3, 4, 5}; // Example internal data
}