package euler;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem_050 {

    static String consecPrimeSum() {
        return consecPrimeSum(1000000);
    }
    
    private static String consecPrimeSum(int thresh) {
        PriorityQueue<int[]> maxheap = new PriorityQueue<int[]>(1000, (a, b) -> b[0] - a[0]);
        int sum = 2;
        
        for (int i = 3; i < thresh; i += 2) {
            int prime, count = 1;
            if (isPrime(sum) && isPrime(i)) prime = i;
            else continue;
            
            while (sum + prime < thresh) {
                sum += prime;
                prime += 2;
                while (!isPrime(prime)) prime += 2;
                count++;
                
                int[] pair = { count, sum };
                if (isPrime(sum)) maxheap.offer(pair);
            }
            
            sum = i;
        }
        
        return Arrays.toString(maxheap.poll());
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
