package org;

import java.util.Arrays;

public class Class6367676a1a6d9265ec0181d4 {
    /** 
     * Aggiunge la Stringa fornita all'array di Stringhe dato, restituendo un nuovo array che consiste nei contenuti dell'array di input più la Stringa fornita.
     * @param array l'array a cui aggiungere (può essere <code>null</code>)
     * @param str la Stringa da aggiungere
     * @return il nuovo array (mai <code>null</code>)
     */
    public static String[] addStringToArray(String[] array, String str) {
        if (array == null) {
            return new String[]{str};
        }
        String[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[array.length] = str;
        return newArray;
    }

    public static void main(String[] args) {
        String[] originalArray = {"Hello", "World"};
        String newString = "!";
        String[] updatedArray = addStringToArray(originalArray, newString);
        System.out.println(Arrays.toString(updatedArray)); // Output: [Hello, World, !]
    }
}