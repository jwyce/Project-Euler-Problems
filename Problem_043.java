package euler;

import java.util.ArrayList;

public class Problem_043 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println(substringDivisabilitySum(get10Pandigitals()));
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}
	
	private static long substringDivisabilitySum(ArrayList<String> pandigitals) {
		long sum = 0;
		
		for (String pandigital : pandigitals) {
			if (substringIsDivisible(pandigital))
				sum += Long.parseLong(pandigital);
		}
		
		return sum;
	}
	
	private static boolean substringIsDivisible(String pandigital) {
		int[] firstSevenPrimes = { 2, 3, 5, 7, 11, 13, 17 };
		
		for (int i = 0; i < firstSevenPrimes.length; i++)
			if (Long.parseLong(pandigital.substring(i + 1, i + 4)) % firstSevenPrimes[i] != 0) 
				return false;
		return true;
	}
	
	private static ArrayList<String> get10Pandigitals() {
		ArrayList<String> perms = new ArrayList<String>();
		perms.add("10");
		perms.add("01");
		
		for(int i = 2; i < 10; i++) {
			ArrayList<String> next = new ArrayList<String>(perms);
			perms.clear();
			for(int j = 0; j <= i; j++) {
				for(int k = 0; k < next.size(); k++) {
					perms.add(new StringBuilder(next.get(k)).insert(j, i).toString());
				}
			}
		}
		
		return perms;
	}
}
