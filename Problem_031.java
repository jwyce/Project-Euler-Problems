package euler;

import java.util.LinkedHashSet;

public class Problem_031 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println();
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}
	
	private static int coinSum() {
		LinkedHashSet<Integer> coins = new LinkedHashSet<Integer>();
		coins.add(1);
		coins.add(2);
		coins.add(5);
		coins.add(10);
		coins.add(20);
		coins.add(50);
		coins.add(100);
		coins.add(200);
		int ways = 0;
		
		for(int i = 1; i < 201; i++) {
			
		}
		
		return ways;
	}
}
