package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.PriorityQueue;

public class Problem_099 {
    
    static String largestExponential() {    // took 12 mins
        PriorityQueue<BigInteger[]> maxheap = new PriorityQueue<BigInteger[]>((a, b) -> b[0].compareTo(a[0]));
        BigInteger lineNumber = BigInteger.ONE;
        String line = "";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("p099_base_exp.txt")))) {
            while ((line = reader.readLine()) != null) {
                // System.out.println(lineNumber.toString());
                String[] pair = line.split(",");
                BigInteger base = new BigInteger(pair[0]);
                int exp = Integer.parseInt(pair[1]);
                base = base.pow(exp);
                
                BigInteger[] element = { base, lineNumber };
                lineNumber = lineNumber.add(BigInteger.ONE);
                maxheap.offer(element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return maxheap.poll()[1].toString();
    }
}
