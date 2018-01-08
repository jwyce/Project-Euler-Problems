package euler;

import java.math.BigInteger;

public class Problem_048 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println(last10SelfPowerSeries());
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}

	private static String last10SelfPowerSeries() {
		BigInteger sum = BigInteger.ZERO;
		
		for (int i = 1; i <= 1000; i++) {
			sum = sum.add(new BigInteger(Integer.toString(i)).pow(i));
		}
		
		String sumString = sum.toString();
		return sumString.substring(sumString.length()-10, sumString.length());
	}
}
