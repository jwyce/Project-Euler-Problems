package euler;

public class Problem_007 {

	static long FindPrime() {
	    return FindPrime(10001);
	}
	
	private static long FindPrime(int nthPrime) {
		int numberOfPrimesFound = 1;
		long currentPrime = 1;
		
		while(numberOfPrimesFound < nthPrime) {
			currentPrime += 2;
			if(isPrime(currentPrime)) {
				numberOfPrimesFound++;
			}
		}
		
		return currentPrime;
	}
	
	private static boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
	}

}
