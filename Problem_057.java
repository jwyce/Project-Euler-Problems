package euler;

import java.math.BigInteger;

public class Problem_057 {

    static int squareRootConvergents() {
        return squareRootConvergents(1000);
    }

    private static int squareRootConvergents(int itr) {
        int count = 0;
        
        for (int i = 0; i <= itr; i++) {
            BigInteger[] root2 = root2(i);
            // System.out.println("[" + root2[0].toString() + ", " + root2[1].toString() + "]");
            if (root2[0].toString().length() > root2[1].toString().length()) count++;
        }
        
        return count;
    }
    
    private static BigInteger[] root2(int itr) {
        BigInteger[] fraction = { new BigInteger("5"), new BigInteger("2") };      // fraction[0] = numerator, fraction[1] = denominator
        
        while (itr > 0) {
            // invert
            BigInteger temp = fraction[0];
            fraction[0] = fraction[1];
            fraction[1] = temp;
            // add 2
            fraction[0] = fraction[0].add(fraction[1].multiply(BigInteger.valueOf(2)));
            itr--;
        }
        
        // subtract 1
        fraction[0] = fraction[0].subtract(fraction[1]);
        return fraction;
    }
    
}
