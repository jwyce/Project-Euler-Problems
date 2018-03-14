package euler;

import java.util.HashMap;

public class Problem_026 {
	
	static int longestReciprocalCylce() {
	    return longestReciprocalCylce(1000);
	}
	
	private static int longestReciprocalCylce(int upperbound) {
		int longestDiv = 0;
		String longestCycle = "";
		
		for(int div = 2; div < upperbound; div++) {
			String currentCycle = getReciprocalCycle(div);
			if(longestCycle.length() < currentCycle.length()) {
				longestCycle = currentCycle;
				longestDiv = div;
			}
		}
		// System.out.println(longestCycle);
		return longestDiv;
	}
	
	private static String getReciprocalCycle(int div) {
		HashMap<Integer, Integer> numerators = new HashMap<Integer, Integer>();
		numerators.put(1, 0);
		String decimal = "";
		int num = 1, index = 1;
		boolean cycleFound = false;

		while(! cycleFound) {
			if(num == 0) return "";		// decimal terminates
			
			int fraction = num / div;
			if(fraction == 0) {
				num *= 10;
			} else {
				num %= div;
				decimal += fraction;
				if(numerators.containsKey(num)) {		// numerator is about to be reused
					cycleFound = true;
					decimal = decimal.substring(numerators.get(num), decimal.length());
				}
				numerators.put(num, index++);
			}
		}
		
		return decimal;
	}
}
