package euler;

import java.math.BigInteger;

public class Problem_357 {

    static String primeGeneratingIntegers() {
        return primeGeneratingIntegers(100000000);
    }
    
    private static String primeGeneratingIntegers(int thresh) {
        BigInteger sum = BigInteger.ZERO;
        int percent = 0;
        
        for (int i = 1; i < thresh; i++) {
            if (isValid(i)) {
                if (100l * i / thresh > percent + 10) {
                    percent += 10;
                    System.out.println(percent + "% complete\tcurrent sum: " + sum.toString());
                }
                sum = sum.add(BigInteger.valueOf(i));
            }
        }
        
        return sum.toString();
    }
    
    private static boolean isValid (int n) {
        for (int d = 1; d*d <= n; d++) {
            if (n % d == 0) {
                if (!isPrime(d + n/d)) return false;
            }
        }
        return true;
    }
    
    private static boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (long i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }
    
}
