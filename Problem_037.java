package euler;

import java.util.ArrayList;

public class Problem_037 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println(truncatablePrimeSum());
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}
	
	private static long truncatablePrimeSum() {
		long sum = 0;
		long possiblePrime = 11;
		ArrayList<Long> truncatablePrimes = new ArrayList<Long>(11);
		
		while(truncatablePrimes.size() < 11) {
			if(isPrime(possiblePrime) && isTruncatableFromRight(possiblePrime) && isTruncatableFromLeft(possiblePrime)) {
				truncatablePrimes.add(possiblePrime);
				sum += possiblePrime;
			}
			possiblePrime += 2;
		}
		
		// System.out.println(truncatablePrimes.toString());
		
		return sum;
	}
	
	private static boolean isTruncatableFromLeft(long num) {
		while(num > 0) {
			num /= 10;
			if(num != 0 && ! isPrime(num)) return false;
		}
		return true;
	}
	
	private static boolean isTruncatableFromRight(long num) {
		int power = (int) Math.log10(num);
		while(power > 0) {
			if(! isPrime(num % (int) Math.pow(10, power))) return false;
			power--;
		}
		return true;
	}
	
	private static boolean isPrime(long num) {
		if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (long i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
	}
}
