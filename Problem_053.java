package euler;

public class Problem_053 {

    static int combinatoricSelections() {
        int count = 0;
        
        for (int n = 1; n < 101; n++) {
            for (int r = 1; r < 101; r++) {
                if (combination(n, r) > 1000000) count++;
            }
        }
        
        return count;
    }
    
    private static double combination(int n, int r) {
        return fact(n) / (fact(r)*fact(n-r));
    }
    
    private static double fact(int x) {
        double fact = 1;
        while (x > 1) {
            fact *= x;
            x--;
        }
        return fact;
    }
}
