package org.class636766fa1a6d9265ec0177a4;

public static Double[] toObject(final double[] array) {
    if (array == null) {
        return null;
    }
    Double[] objectArray = new Double[array.length];
    for (int i = 0; i < array.length; i++) {
        objectArray[i] = array[i]; // Autoboxing from double to Double
    }
    return objectArray;
}