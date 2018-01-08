package euler;

public class Problem_031 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println(coinCombos(200));
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}
	
	private static int coinCombos(int targetAmount) {
		int[] coinSizes = { 1, 2, 5, 10, 20, 50, 100, 200 };
		int[] ways = new int[targetAmount + 1];
		ways[0] = 1;
		 
		for (int i = 0; i < coinSizes.length; i++) {
		    for (int j = coinSizes[i]; j <= targetAmount; j++) {
		        ways[j] += ways[j - coinSizes[i]];
		    }
		}
		
		return ways[targetAmount];
	}
}
