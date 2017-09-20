package euler;

import java.util.ArrayList;
import java.util.Collections;

public class Problem_041 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println(largestPandigitalPrime());
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}
	
	private static int largestPandigitalPrime() {
		for(int i = 9; i > 2; i--) {
			ArrayList<String> perms = getLexographicPermutations(i);
			for(int j = perms.size() - 1; j >= 0; j--) {
				int pandigital = Integer.parseInt(perms.get(j));
				if(pandigital % 5 == 0) continue;
				if(isPrime(pandigital)) {
					return pandigital;
				}
			}
		}
		
		return 0;
	}
	
	private static ArrayList<String> getLexographicPermutations(int n) {		// reused solution to euler p_024 w/ a few changes
		ArrayList<String> perms = new ArrayList<String>();
		perms.add("1");
		
		for(int i = 2; i <= n; i++) {
			ArrayList<String> next = new ArrayList<String>(perms);
			perms.clear();
			for(int j = 0; j < i; j++) {
				for(int k = 0; k < next.size(); k++) {
					perms.add(new StringBuilder(next.get(k)).insert(j, i).toString());
				}
			}
		}
		
		
		Collections.sort(perms);
		return perms;
	}
	
	private static boolean isPrime(long num) {
		if (num < 2) return false;
                if (num == 2) return true;
                if (num % 2 == 0) return false;
                for (long i = 3; i * i <= num; i += 2) if (num % i == 0) return false;
                return true;
	}
}
