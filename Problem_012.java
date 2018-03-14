package euler;

public class Problem_012 {

	static int FindTriangleNumber() {
		int termInSeries = 1, currentTerm = 0;
		boolean found = false;
		
		while(!found) {
			currentTerm = 0;
			
			for(int i = termInSeries; i > 0; i--) {
				currentTerm += i;
			}
			
			found = FindFactors(currentTerm) > 500;
			termInSeries ++;
		}
		
		return currentTerm;
	}

	private static int FindFactors(int currentTerm) {
		int factors = 0;
		
		for(int i = 1; i * i <= currentTerm; i++) {
			if(currentTerm % i == 0) {
				factors++;
			}
		}	
		
		return factors * 2;
	}

}
