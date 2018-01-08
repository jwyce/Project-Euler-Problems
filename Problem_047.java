package euler;

import java.util.ArrayList;
import java.util.HashSet;

public class Problem_047 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println(firstNNumsWithNDistinctPrimeFactors(4).get(0));
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}

	private static ArrayList<Long> firstNNumsWithNDistinctPrimeFactors(int n) {
		ArrayList<Long> nums = new ArrayList<Long>();
		ArrayList<Long> memo = new ArrayList<Long>();
		memo.add(2L);
		long c = 3;
		while (nums.size() < n) {
			if (isPrime(c)) {
				memo.add(c);
				nums.clear();
			} else {
				if (getNumberOfDistinctPrimeFactors(c, memo) == n)
					nums.add(c);
				else 
					nums.clear();
			}
			c++;
		}
		for (Long num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
		return nums;
	}
	
	private static int getNumberOfDistinctPrimeFactors(long n, ArrayList<Long> primes) {
		HashSet<Long> primeFactors = new HashSet<>();
		while (n > 1) {
			for (Long prime : primes) {
				if ((double) n / prime == n / prime) {
					n /= prime;
					primeFactors.add(prime);
					break;
				}
			}
		}
		return primeFactors.size();
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
