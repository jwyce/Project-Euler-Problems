package euler;

import java.math.BigInteger;

public class Problem_065 {

    static int numeratorSum() {
        int sum = 0;
        BigInteger fraction[] = eConvergence(99);
        String numerator = fraction[0].toString();
        
        for (int i = 0; i < numerator.length(); i++) {
            sum += Integer.parseInt(numerator.substring(i, i+1));
        }
        
        return sum;
    }
    
    private static BigInteger[] eConvergence(int itr) {
        BigInteger fraction[] = { BigInteger.ONE, BigInteger.ONE };
        if (itr == 0) {
            fraction[0] = fraction[0].add(BigInteger.ONE);
            return fraction;
        }
        if (itr == 1) {
            fraction[0] = fraction[0].add(BigInteger.valueOf(2));
            return fraction;
        }
        
        if ((itr+1) % 3 == 0)
            fraction[1] = BigInteger.valueOf(2*((itr+1) / 3));
        if (itr % 3 == 0) {
            fraction[0] = fraction[0].add(BigInteger.valueOf(2*((itr) / 3))) ;
        } else {
            fraction[0] = fraction[0].add(fraction[1]);
        }
        
        while (itr > 1) {
            // invert
            BigInteger temp = fraction[0];
            fraction[0] = fraction[1];
            fraction[1] = temp;
            // add 1 or 2k
            if ((itr-1) % 3 == 0) {
                fraction[0] = fraction[0].add(fraction[1].multiply(BigInteger.valueOf(2*((itr-1) / 3))));
            } else {
                fraction[0] = fraction[0].add(fraction[1]);
            }
            itr--;
        }
        fraction[0] = fraction[0].add(fraction[1]);
        return fraction;
    }
    
}
