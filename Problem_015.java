package euler;

public class Problem_015 {
	
	static long findPaths() {
	    return findPaths(20);
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
