package euler;

public class Problem_036 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println(doubleBasePalindromSum(1000000));
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}
	
	private static int doubleBasePalindromSum(int upperbound) {
		int sum = 0;
		
		for(int i = 1; i < upperbound; i++) {
			if(isPalindrome(Integer.toString(i)) && isPalindrome(Integer.toBinaryString(i))) {
				sum += i;
			}
		}
		
		return sum;
	}
	
	private static boolean isPalindrome(String num) { 		
		String numStr = num;
		StringBuilder reverse = new StringBuilder(numStr).reverse();
		return numStr.equals(reverse.toString());
	}
}
