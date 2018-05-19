package euler;

public class Problem_206 {

    static int concealedSquare() {
        int start = (int) Math.sqrt(1020304050607080900l), end = (int) Math.sqrt(1929394959697989990l);
        
        for (int i = start; i <= end; i++) {
            long num = (long) i*i;
            int test = 0, c = 0, d = 10;
            while (num > 0) {
                if ((num % 10) != (d-- % 10)) break;
                test += (num % 10) * Math.pow(10, c);
                num /= 100;
                c++;
                if (test == 1234567890) return i;
            }
        }
        
        return -1;
    }
}
