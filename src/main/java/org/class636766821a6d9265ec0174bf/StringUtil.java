package org.class636766821a6d9265ec0174bf;

import java.beans.Introspector;
import java.util.Locale;

public class StringUtil {

    /** 
     * Inverso di Introspector.decapitalize
     */
    public static String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase(Locale.ROOT) + name.substring(1).toLowerCase(Locale.ROOT);
    }

    public static void main(String[] args) {
        // Test the capitalize method
        System.out.println(capitalize("hello")); // Output: Hello
        System.out.println(capitalize("java"));   // Output: Java
        System.out.println(capitalize("WORLD"));  // Output: World
        System.out.println(capitalize(""));       // Output: (empty string)
        System.out.println(capitalize(null));     // Output: null
    }
}