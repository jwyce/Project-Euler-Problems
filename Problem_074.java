package euler;

import java.util.ArrayList;

public class Problem_074 {

    static int digitFactorialChains() {
        return digitFactorialChains(1000000, 60);
    }

    private static int digitFactorialChains(int thresh, int size) {
        int count = 0;
        
        for (int i = 10; i < thresh; i++) {
            ArrayList<String> chain = new ArrayList<String>();
            chain.add(Integer.toString(i));
            String next = digitFact(Integer.toString(i));
            
            while (!chain.contains(next)) {
                chain.add(next);
                next = digitFact(next);
            }
            
            if (chain.size() == size) {
                // System.out.println(Arrays.toString(chain.toArray()));
                count++;
            }
        }
        
        return count;
    }
    
    private static String digitFact(String x) {
        int sum = 0;
        
        for (int i = 0; i < x.length(); i++) {
            sum += fact(Integer.parseInt(x.substring(i, i+1)));
        }
        
        return Integer.toString(sum);
    }
    
    private static int fact(int n) {
        int fact = 1;
        
        while (n > 1) {
            fact *= n;
            n--;
        }
        
        return fact;
    }
    
}
