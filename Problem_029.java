package euler;

import java.util.HashSet;
import java.util.Set;

public class Problem_029 {

	static int distinctPowers() {
	    return distinctPowers(100);
	}
	
	private static int distinctPowers(int upperBound) {
		Set<Double> distinctPowers = new HashSet<Double>(upperBound * 10);
		
		for(int i = 2; i <= upperBound; i++) {
			for(int j = 2; j <= upperBound; j++) {
				distinctPowers.add(Math.pow(i, j));
			}
		}
		
		return distinctPowers.size();
	}

}
