package euler;

public class Problem_092 {

    static int squareDigitChains() {
        return squareDigitChains(10000000);
    }

    private static int squareDigitChains(int thresh) {
        int count = 0;
        
        for (int i = 1; i < thresh; i++) {
            String next = digitSquareSum(Integer.toString(i));
            while (!next.equals("1") && !next.equals("89")) {
                next = digitSquareSum(next);
            }
            if (next.equals("89")) count++;
        }
        
        return count;
    }
    
    private static String digitSquareSum(String x) {
        int sum = 0;
        
        for (int i = 0; i < x.length(); i++) {
            sum += (int) Math.pow(Integer.parseInt(x.substring(i, i+1)), 2);
        }
        
        return Integer.toString(sum);
    }
}
