package euler;

import java.util.Arrays;

public class Problem_049 {

    static String primePerm() {
        String seq;
        
        for (int n = 1001; n < 10000; n += 2) {
            seq = "";
            if (isPrime(n)) {
                if (n == 1487 || n == 4817 || n == 8157) continue;
                seq += n;
                for (int i = 1000; i < 3333; i++) {
                    if (isPrime(i+n) && isPrime(2*i+n) && isPerm(Integer.toString(n).toCharArray(), Integer.toString(i+n).toCharArray())
                            && isPerm(Integer.toString(n).toCharArray(), Integer.toString(2*i+n).toCharArray())) {
                        seq += (i+n);
                        seq += (2*i+n);
                        return seq;
                    }
                }
            }
        }
        
        return "";
    }
    
    private static boolean isPerm(char[] a, char[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.toString(a).equals(Arrays.toString(b));
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
