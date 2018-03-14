package euler;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem_025 {
	
	static int nDigitFibIndex() {
	    return nDigitFibIndex(1000);
	}
	
	private static int nDigitFibIndex(int n) {
		ArrayList<BigInteger> fib = new ArrayList<BigInteger>(n * 10);
		fib.add(BigInteger.ONE);
		fib.add(BigInteger.ONE);
		int index = 1;
		
		while(fib.get(fib.size() - 1).toString().length() < n) {
			index++;
			fib.add(fib.get(index - 1).add(fib.get(index - 2)));
		}
		
		return index + 1;
	}
	
}
