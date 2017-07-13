package euler;

public class Problem_027 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
	
		System.out.println(quadraticPrimeProduct());
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}
	
	private static int quadraticPrimeProduct() {
		int product = 0;
		int mostConsecutivePrimes = 0;
		
		for(int a = -999; a < 1000; a++) {
			for(int b = -1000; b < 1001; b++) {
				int consecPrimes = consecutivePrimes(a, b);
				if(mostConsecutivePrimes < consecPrimes) {
					mostConsecutivePrimes = consecPrimes;
					product = a * b;
					// System.out.println(mostConsecutivePrimes + " : " + a + " * " + b + " = " + product);
				}
					
			}
		}
		
		return product;
	}
	
	private static int consecutivePrimes(int a, int b) {
		int primes = 0, n = 0;
		boolean isConsecutive = true;
		
		while(isConsecutive) {
			isConsecutive = isPrime((n*n) + (a*n) + b);
			n++;
			primes++;
		}
		
		return primes - 1;
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
