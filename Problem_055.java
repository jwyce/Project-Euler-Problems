package euler;

import java.math.BigInteger;

public class Problem_055 {

    static int lychrelNums() {
        return lychrelNums(10000);
    }

    private static int lychrelNums(int thresh) {
        int count = 0;
        
        for (int i = 10; i < thresh; i++) {
            if (isLychrel(i)) count++;
        }
        
        return count;
    }

    private static boolean isLychrel(int num) {
        int i = 0;
        BigInteger bi = new BigInteger(Integer.toString(num));
        
        while (i < 50) {
            bi = bi.add(reverse(bi));
            if (isPalindrome(bi)) return false;
            i++;
        }
        
        return true;
    }
    
    private static BigInteger reverse(BigInteger bi) {
        String numStr = bi.toString();
        StringBuilder reverse = new StringBuilder(numStr).reverse();
        return new BigInteger(reverse.toString());
    }
    
    private static boolean isPalindrome(BigInteger bi) {
        String numStr = bi.toString();
        StringBuilder reverse = new StringBuilder(numStr).reverse();
        return numStr.equals(reverse.toString());
    }
}
