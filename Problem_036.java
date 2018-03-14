package euler;

public class Problem_036 {

	static int doubleBasePalindromSum() {
	    return doubleBasePalindromSum(1000000);
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
