package euler;

public class Problem_015 {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println("There are " + findPaths(20) + " such paths in a 20 x 20 grid.");
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}

	private static long findPaths(int gridSize) {
		long paths = 1;
		
		for(int i = 1; i <= gridSize; i++) {
			paths *= (gridSize + i);
			paths /= i;
		}
		
		return paths;
	}

}
