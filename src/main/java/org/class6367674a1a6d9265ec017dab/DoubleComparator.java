package org.class6367674a1a6d9265ec017dab;

import java.util.Comparator;

public class DoubleComparator implements Comparator<Double> {
    
    /** 
     * Confronta due valori in virgola mobile. Restituisce 0 se sono uguali, -1 se {@literal o1 < o2}, 1 altrimenti
     * @param o1 il primo valore
     * @param o2 il secondo valore
     * @return 0 se sono uguali, -1 se {@literal o1 < o2}, 1 altrimenti
     */
    @Override 
    public int compare(Double o1, Double o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return -1; // null is considered less than any non-null value
        }
        if (o2 == null) {
            return 1; // any non-null value is considered greater than null
        }
        return o1.compareTo(o2);
    }
}