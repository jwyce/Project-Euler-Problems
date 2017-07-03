package euler;

public class Problem_006 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println("The sum square difference is " + SumSquareDifference (100) + ".");
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}

	private static int SumSquareDifference(int length) {
		int squareSum = (int) Math.pow((length + 1) * length / 2, 2);
		int sumOfSquares = 1;
		
		for(int i = 2; i <= length; i++) {
			sumOfSquares += (i * i);
		}
		
		return Math.abs(sumOfSquares - squareSum);
	}
	
}
