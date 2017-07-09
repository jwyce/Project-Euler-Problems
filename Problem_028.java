package euler;

public class Problem_028 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		System.out.println(spiralDiagonalSum(1001));
		
		long endTime = System.nanoTime();
		System.out.println("It took " + (endTime - startTime) + " ns.");
	}

	private static int spiralDiagonalSum(int n) {
		int sum = 1;
		int gap = 1;
		
		for(int i = 3; i <= n * n; i += 1 + gap) {
			if(Math.sqrt(i) - (int) Math.sqrt(i) == 0)
				gap = (int) Math.sqrt(i);
			sum += i;
		}
		
		return sum;
	}
	
}
