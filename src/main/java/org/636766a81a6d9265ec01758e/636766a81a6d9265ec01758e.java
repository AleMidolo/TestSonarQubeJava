public class PrimeCapacity {

    /**
     * एक प्रमुख संख्या लौटाता है जो <code>&gt;= desiredCapacity</code> है और <code>desiredCapacity</code> के बहुत करीब है (यदि <code>desiredCapacity &gt;= 1000</code> है तो 11% के भीतर)।
     * @param desiredCapacity उपयोगकर्ता द्वारा इच्छित क्षमता।
     * @return वह क्षमता जो हैशटेबल के लिए उपयोग की जानी चाहिए।
     */
    public static int nextPrime(int desiredCapacity) {
        if (desiredCapacity <= 1) {
            return 2;
        }
        int capacity = desiredCapacity;
        if (capacity % 2 == 0) {
            capacity++;
        }
        while (true) {
            if (isPrime(capacity)) {
                if (desiredCapacity >= 1000) {
                    int upperLimit = (int) (desiredCapacity * 1.11);
                    if (capacity <= upperLimit) {
                        return capacity;
                    }
                } else {
                    return capacity;
                }
            }
            capacity += 2; // Check only odd numbers
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int desiredCapacity = 1000;
        int primeCapacity = nextPrime(desiredCapacity);
        System.out.println("Next prime capacity: " + primeCapacity);
    }
}