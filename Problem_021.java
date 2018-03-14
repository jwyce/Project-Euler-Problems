package euler;

public class Problem_021 {
	
	static int amicableNumberSum() {
	    return amicableNumberSum(10000);
	}
	
	private static int amicableNumberSum(int upperbound) {
		int sum = 0;
		
		for(int i = 2; i < upperbound; i++) {
			int possibleAmicableNum = sumOfProperDivisors(i);
			if(i != possibleAmicableNum && sumOfProperDivisors(possibleAmicableNum) == i) {
				sum += i;
			}
		}
		
		return sum;
	}

	private static int sumOfProperDivisors(int n) {
		int sum = 0;
		
		for(int i = 1; i < n; i++) {
			if(n / i == (double) n / i) {
				sum += i;
			}
		}
		
		return sum;
	}
	
}
