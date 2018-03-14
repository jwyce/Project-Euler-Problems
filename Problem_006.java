package euler;

public class Problem_006 {

	static int SumSquareDifference() {
	    return SumSquareDifference(100);
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
