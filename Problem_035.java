package euler;

public class Problem_035 {
    
	static int numberOfCircularPrimes() {
	    return numberOfCircularPrimes(1000000);
	}
	
	private static int numberOfCircularPrimes(int upperbound) {
		int count = 1;
		for(int i = 3; i < upperbound; i += 2)
			if(isCircularPrime(i)) count++;
		return count;
	}
	
	private static boolean isCircularPrime(long num) {
		String numStr = Long.toString(num);
		for(int i = 0; i < numStr.length(); i++) {
			if(! isPrime(Long.parseLong(numStr))) return false;
			char firstChar = numStr.charAt(0);
			numStr = numStr.substring(1);
			numStr += firstChar;
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
