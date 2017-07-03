package euler;

public class Problem_001 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println("The answer is " + SumMultiplesOf3Or5 () + ".");
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}
	
	private static int SumMultiplesOf3Or5 () {
		int sum = 0;
		
		for(int num = 1; num < 1000; num++) {
			if(num % 5 == 0 || num % 3 == 0) {
				sum += num;
			}
		}
		
		return sum;
	}

}
