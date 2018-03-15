package euler;

public class Problem_058 {

    static int spiralPrimes() {
        return spiralPrimes(0.1f);
    }

    private static int spiralPrimes(float pThresh) {
        int numPrimes = 0;
        int total = 0;
        int i = 3, gap = 1;
        
        while ((float) numPrimes / total >= pThresh || Float.compare((float) numPrimes / total, Float.NaN) == 0) {
            if(Math.sqrt(i) - (int) Math.sqrt(i) == 0)
                gap = (int) Math.sqrt(i);
            if (isPrime(i)) numPrimes++;
            total++;
            i += gap + 1;
        }
        
        return gap;
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
