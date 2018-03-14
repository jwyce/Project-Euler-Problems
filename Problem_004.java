package euler;

public class Problem_004 { 
	
	static int LargestPalindromeProduct() {
	    return fasterLargestPalindromeProduct(3);
	}
	
	private static int fasterLargestPalindromeProduct(int n) {
		int greatestPalindrome = 0;
		int smallestMultiple = (int) Math.pow(10, n - 1);
		
		for(int i = (int) Math.pow(10, n) - 1; i >= smallestMultiple; i--) { 	// count down and avoid the same product twice
			for(int j = i; j >= smallestMultiple; j--) {
				int product = i * j;
				
				if(greatestPalindrome >= product) {
					break;
				} else if (fasterIsPalindrome(product)){
					greatestPalindrome = product;
				}
			}
		}
		
		return greatestPalindrome;
	}
	
	private static boolean fasterIsPalindrome(int num) { 		// use of the API for a simpler and faster palindrome test
		String numStr = Integer.toString(num);
		StringBuilder reverse = new StringBuilder(numStr).reverse();
		return numStr.equals(reverse.toString());
	}
	
	// ---------------------------------------- [ old code ] ------------------------------------------------
	
//	private static int LargestPalindromeProduct() {
//		int possiblePalindrome = 0;
//		// int multiple1 = 0, multiple2 = 0;
//		
//		for(int i = 100; i < 1000; i++){
//			for(int j = 100; j < 1000; j++){
//				if(isPalindrome(i * j) && possiblePalindrome < i * j){  
//					possiblePalindrome = i * j;
//					// multiple1 = i;
//					// multiple2 = j;
//				}
//			}
//		}
//			
//		return possiblePalindrome;
//	}
//	
//	private static boolean isPalindrome(int num) {
//		String mirror = "";
//		for(int i = Integer.toString(num).length() - 1; i >= 0; i--)
//			mirror += Integer.toString(num).substring(i, i + 1);
//		
//		return Integer.toString(num).equals(mirror);
//	}
	
}
