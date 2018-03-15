package euler;

import java.math.BigInteger;
import java.util.Collections;
import java.util.PriorityQueue;

public class Problem_056 {

    static int powerDigitSum() {
        return powerDigitSum(100);
    }

    private static int powerDigitSum(int thresh) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(10000, Collections.reverseOrder());
        
        for (int a = 1; a < thresh; a++) {
            for (int b = 1; b < thresh; b++) {
                BigInteger bi = new BigInteger(Integer.toString(a));
                bi = bi.pow(b);
                maxheap.offer(digitalSum(bi));
            }
        }
        
        return maxheap.poll();
    }
    
    private static int digitalSum(BigInteger bi) {
        String numStr = bi.toString();
        int sum = 0;
        
        for (int i = 0; i < numStr.length(); i++) {
            sum += Integer.parseInt(numStr.substring(i, i+1));
        }
        
        return sum;
    }
}
