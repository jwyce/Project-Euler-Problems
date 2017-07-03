package euler;

import java.math.BigInteger;

public class Problem_016 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println("The sum of the digits of 2^1000 is " + findPowerSum(1000));
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}

	private static int findPowerSum(int exponent) {
		BigInteger bigInt = new BigInteger("1");
		String digits;
		int sum = 0;
		
		for(int i = 0; i < exponent; i++) {
			bigInt = bigInt.multiply(BigInteger.valueOf(2));
		}
		
		digits = bigInt.toString();
		
		for(int i = 0; i < digits.length(); i++) {
			sum += Integer.parseInt(digits.substring(i, i + 1));
		}
		
		return sum;
	}

}
