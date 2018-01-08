package euler;

import java.util.ArrayList;

public class Problem_046 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println(smallestGoldbachException());
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}
	
	private static long smallestGoldbachException() {
		long n = 3;
		ArrayList<Long> memo = new ArrayList<>();
		memo.add(2L);
		memo.add(n);
		
		while (true) {
			n += 2;
			if (!isPrime(n)) {
				if (!satisfiesGoldbach(n, memo))
					break;
			} else {
				memo.add(n);
			}
		}
		
		return n;
	}

	private static boolean satisfiesGoldbach(long n, ArrayList<Long> primes) {
		for (Long prime : primes) {
			for (int i = 0; i < n/2; i++) {
				long test = prime + 2*i*i;
				if (n == test) return true;
				if (test > n) break;
			}
		}
		return false;
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
