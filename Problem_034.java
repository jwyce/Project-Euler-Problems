package euler;

import java.util.ArrayList;

public class Problem_034 {

    static int digitFactorialSum() {
		ArrayList<Integer> curiousNums = new ArrayList<Integer>(30);
		int sum = 0;
		
		for(int i = 11; i < 50000; i ++) {
			if(isCurious(i)) {
				sum += i;
				curiousNums.add(i);
			}
		}
		// System.out.println(curiousNums.toString());
		
		return sum;
	}
	
	private static boolean isCurious(int n) {
		int sum = 0;
		String num = Integer.toString(n);
		
		if(n == 1 || n == 2) return false;
		for(int i = 0; i < num.length(); i++) {
			sum += factorial(Integer.parseInt(num.substring(i, i + 1)));
		}
		return sum == n;
	}
	
	private static long factorial(int n) {
		long factorial = 1;
		if(n == 0) return 1;
		for(int i = n; i > 0; i--) {
			factorial *= i;
		}
		return factorial;
	}
}
