package euler;

import java.math.BigInteger;

public class Problem_020 {
	
	static int factorialDigitSum() {
	    return factorialDigitSum(100);
	}
	
	private static int factorialDigitSum(int num) {
		String factorial = factorial(num);
		int sum = 0;
		
		for(int i = 1; i < 10; i++) {
			sum += (i * factorial.split(Integer.toString(i)).length - i);
		}
		
		return sum;
	}
	
	private static String factorial(int num) {
		BigInteger factorial = BigInteger.valueOf(num);
		
		for(int i = num - 1; i > 0; i--) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		
		return factorial.toString();
	}
	
}
