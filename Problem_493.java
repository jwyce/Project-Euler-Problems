package euler;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Problem_493 {

    static String expectedNumberOfDistinctColors() {
        NumberFormat formatter = new DecimalFormat("#0.000000000");  
        double probNeverSelected = nCk(60, 20) / nCk(70, 20);
        return formatter.format(7 * (1 - probNeverSelected));
    }
    
    private static double nCk(double n, double k) {
        return fact(n) / (fact(k) * fact(n-k));
    }
    
    private static double fact(double x) {
        int itr = (int) x-1;
        
        while (itr > 0) {
            x *= itr;
            itr--;
        }
        
        return x;
    }
}
