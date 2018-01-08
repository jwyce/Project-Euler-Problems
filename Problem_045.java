package euler;

public class Problem_045 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println(triPentHexNum());
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}
	
	private static long triPentHexNum() {
		int n = 144;
		long next = 2*n*n-n;
		while (!isPentagonal(next) || !isTriangular(next)) {
			n++;
			next = 2*n*n-n;
		}
		return next;
	}
	
	// use quadratic formula
	private static boolean isPentagonal(long num) {
		double pentTest = (1 + Math.sqrt(1 + 24*num))/6.0;
		return pentTest == (long) pentTest;
	}
	private static boolean isTriangular(long num) {
		double triTest = (-1 + Math.sqrt(1 + 8*num))/2.0;
		return triTest == (long) triTest;
	}
}
