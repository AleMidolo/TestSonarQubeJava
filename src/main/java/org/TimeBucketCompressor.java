package org;

public class TimeBucketCompressor {

    /**
     * Segui il valore di dayStep per riformattare il valore numerico "long" del bucket temporale. 
     * Ad esempio, se dayStep == 11, il bucket di tempo riformattato per 20000105 è 20000101, 
     * per 20000115 è 20000112, e per 20000123 è 20000123.
     */
    static long compressTimeBucket(long timeBucket, int dayStep) {
        // Estrai l'anno, il mese e il giorno dal timeBucket
        int year = (int) (timeBucket / 10000);
        int month = (int) ((timeBucket % 10000) / 100);
        int day = (int) (timeBucket % 100);
        
        // Calcola il giorno riformattato
        int newDay = (day / dayStep) * dayStep;
        
        // Se il nuovo giorno è 0, significa che dobbiamo tornare al giorno precedente
        if (newDay == 0) {
            newDay = dayStep;
            month--;
            if (month < 1) {
                month = 12;
                year--;
            }
        }
        
        // Riformatta il nuovo bucket temporale
        return year * 10000 + month * 100 + newDay;
    }

    public static void main(String[] args) {
        // Esempi di utilizzo
        System.out.println(compressTimeBucket(20000105, 11)); // Output: 20000101
        System.out.println(compressTimeBucket(20000115, 11)); // Output: 20000112
        System.out.println(compressTimeBucket(20000123, 11)); // Output: 20000123
    }
}