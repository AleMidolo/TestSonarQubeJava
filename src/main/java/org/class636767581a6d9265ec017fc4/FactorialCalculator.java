package org.class636767581a6d9265ec017fc4;

public class FactorialCalculator {

    /** 
     * Calcola il fattoriale di $n$.
     * @param n il numero di input
     * @return il fattoriale
     */
    public static long fattoriale(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Il numero deve essere non negativo.");
        }
        long risultato = 1;
        for (int i = 2; i <= n; i++) {
            risultato *= i;
        }
        return risultato;
    }

    public static void main(String[] args) {
        int numero = 5; // Esempio di utilizzo
        long fatt = fattoriale(numero);
        System.out.println("Il fattoriale di " + numero + " è " + fatt);
    }
}