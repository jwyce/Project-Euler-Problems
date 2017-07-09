package euler;

import java.util.ArrayList;

public class Problem_032 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println(pandigitalProductSum());
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}
	
	private static int pandigitalProductSum() {
		ArrayList<Integer> products = new ArrayList<Integer>(50);
		int sum = 0;
		
		for(int i = 2; i < 49; i++) {
			for(int j = i; j < 2000; j++) {
				if(! products.contains(i * j) && isPandigital(i + "*" + j + "=" + (i*j) + " ")) {
					sum += (i*j);
					products.add(i * j);
				}
			}
		}
		
		return sum;
	}
	
	private static boolean isPandigital(String s) {
		if(s.contains("0")) return false;
		for(int i = 1; i < 10; i++) {
			if(s.split(Integer.toString(i)).length - 1 != 1) 
				return false;
		}
		// System.out.println(s);
		return true;
	}
	
}
