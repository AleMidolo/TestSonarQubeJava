package org;

import java.util.HashSet;

public class Class6367672d1a6d9265ec017c78 {
    private HashSet<Integer> set;

    public Class6367672d1a6d9265ec017c78() {
        set = new HashSet<>();
    }

    /** 
     * Inserisce un valore nel "set". Restituisce true se il "set" non conteneva già l'elemento specificato. 
     */
    public boolean insert(int val) {
        return set.add(val);
    }

    public static void main(String[] args) {
        Class6367672d1a6d9265ec017c78 customSet = new Class6367672d1a6d9265ec017c78();
        System.out.println(customSet.insert(5)); // true
        System.out.println(customSet.insert(5)); // false
    }
}