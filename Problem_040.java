package euler;

import java.util.LinkedList;

public class Problem_040 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println(champernowneConstant());
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}
	
	private static int champernowneConstant() {
		LinkedList<Integer> constant = new LinkedList<Integer>();		// linked lists achieve O(1) insertion whereas strings/char arrays achieve O(n)
		int i = 1;
		int product = 1;
		
		while(constant.size() < 1000000) {
			String str = Integer.toString(i);
			for(int j = 0; j < str.length(); j++) {
				constant.add(Integer.parseInt(Character.toString(str.charAt(j))));
			}
			i++;
		}
	
		for(int j = 1; j <= 1000000; j *= 10) {
			int digit = constant.get(j - 1);
			// System.out.println(digit);
			product *= digit;
		}
		
		return product;
	}
}
