package euler;

import java.util.Arrays;

public class Problem_052 {

    static int permutedMultiples() {
        int n = 1;
        while (!isPerm(Integer.toString(n).toCharArray(), Integer.toString(2*n).toCharArray()) || 
                !isPerm(Integer.toString(n).toCharArray(), Integer.toString(3*n).toCharArray()) ||
                !isPerm(Integer.toString(n).toCharArray(), Integer.toString(4*n).toCharArray()) ||
                !isPerm(Integer.toString(n).toCharArray(), Integer.toString(5*n).toCharArray()) ||
                !isPerm(Integer.toString(n).toCharArray(), Integer.toString(6*n).toCharArray())) {
            n++;
        }
        return n;
    }
    
    private static boolean isPerm(char[] a, char[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.toString(a).equals(Arrays.toString(b));
    }
}
