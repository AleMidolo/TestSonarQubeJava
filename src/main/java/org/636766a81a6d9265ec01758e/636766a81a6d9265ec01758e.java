import java.util.*;

public class PrimeUtil {

    /**
     * Devuelve un número primo que es >= desiredCapacity y muy cercano a desiredCapacity
     * (dentro del 11% si desiredCapacity >= 1000).
     * @param desiredCapacity la capacidad deseada por el usuario.
     * @return la capacidad que se debe utilizar para una tabla hash.
     */
    public static int nextPrime(int desiredCapacity) {
        if (desiredCapacity <= 2) {
            return 2;
        }
        int candidate = desiredCapacity;
        if (candidate % 2 == 0) {
            candidate++;
        }
        while (!isPrime(candidate)) {
            candidate += 2;
            if (desiredCapacity >= 1000 && candidate > desiredCapacity * 1.11) {
                candidate = desiredCapacity;
                while (!isPrime(candidate)) {
                    candidate++;
                }
                return candidate;
            }
        }
        return candidate;
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(nextPrime(1000));  // Ejemplo de uso
    }
}