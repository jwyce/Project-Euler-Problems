package euler;

public class Problem_010 {

	static long SumOfPrimes() {
		long sum = 2;
		
		for(int possiblePrime = 3; possiblePrime < 2000000; possiblePrime += 2) {
			if(isPrime(possiblePrime)) {
				sum += possiblePrime;
			}
		}
		
		return sum;
	}

	private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
	}

}
