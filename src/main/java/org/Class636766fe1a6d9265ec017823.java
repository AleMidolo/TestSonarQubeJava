package org;

import java.util.HashMap;
import java.util.Map;

public class Class636766fe1a6d9265ec017823 {
    private final Map<String, Integer> constantPool;
    private int nextIndex;

    public Class636766fe1a6d9265ec017823() {
        this.constantPool = new HashMap<>();
        this.nextIndex = 0;
    }

    /**
     * Aggiunge un CONSTANT_NameAndType_info al pool di costanti di questa tabella dei simboli. Non fa nulla se il pool di costanti contiene già un elemento simile.
     * @param name il nome di un campo o di un metodo.
     * @param descriptor un descrittore di campo o di metodo.
     * @return un nuovo simbolo o un simbolo già esistente con il valore fornito.
     */
    public int addConstantNameAndType(final String name, final String descriptor) {
        String key = name + ":" + descriptor;
        if (!constantPool.containsKey(key)) {
            constantPool.put(key, nextIndex++);
        }
        return constantPool.get(key);
    }

    public static void main(String[] args) {
        Class636766fe1a6d9265ec017823 symbolTable = new Class636766fe1a6d9265ec017823();
        int index1 = symbolTable.addConstantNameAndType("myField", "I");
        int index2 = symbolTable.addConstantNameAndType("myField", "I");
        System.out.println("Index of myField: " + index1);
        System.out.println("Index of myField (duplicate): " + index2);
    }
}