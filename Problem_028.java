package euler;

public class Problem_028 {
	
	static int spiralDiagonalSum() {
	    return spiralDiagonalSum(1001);
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
