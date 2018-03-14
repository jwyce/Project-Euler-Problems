package euler;

import java.util.ArrayList;

public class Problem_030 {

    static int sumDigitFifthPowers() {
		ArrayList<Integer> digitFifthPowers = new ArrayList<Integer>(30);
		int sum = 0;
		
		for(int i = 4001; i < 200000; i++) {
			if(Integer.toString(i).replace("0", "").length() < 2) continue;
			
			if(i == digitFifthPowers(i)) {
				digitFifthPowers.add(i);
				sum += i;
			}
		}
		// System.out.println(digitFifthPowers.toString());
		
		return sum;
	}
	
	private static int digitFifthPowers(int n) {
		int sum = 0;
		String num = Integer.toString(n);
		
		for(int i = 0; i < num.length(); i++) {
			sum += (int) Math.pow(Integer.parseInt(num.substring(i, i + 1)), 5);
		}
		
		return sum;
	}
}
