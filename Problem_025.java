package euler;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem_025 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println("The first fibonacci number with 1000 digits occurs at index "
				+ nDigitFibIndex(1000));
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
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
