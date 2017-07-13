package euler;

public class Problem_021 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println(amicableNumberSum(10000));
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
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
