package euler;

public class Problem_003 {
	
	static long LargestPrimeFactor() {
	    return LargestPrimeFactor(600851475143L);
	}

	private static long LargestPrimeFactor(long num) {
		long pFactor = (num % 2 == 0 ? 2L : 1L);
		
		for(long i = 3; i <= num; i += 2) {
			if(num % i == 0 && isPrime(i)) {
				if(pFactor < i) pFactor = i;
				num /= i;
			}
		}
		
		return pFactor;
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
