package euler;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Problem_031 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println(coinCombos());
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}
	
	private static int coinCombos() {
		LinkedHashSet<String> combos = new LinkedHashSet<String>();
		ArrayList<Integer> coinVals = new ArrayList<Integer>(8);
		coinVals.add(200);
		coinVals.add(100);
		coinVals.add(50);
		coinVals.add(20);
		coinVals.add(10);
		coinVals.add(5);
		coinVals.add(2);
		coinVals.add(1);
		
		while(! coinVals.isEmpty()) {		
			for(int i = 0; i < coinVals.size(); i++) {
				for(int j = i; j < coinVals.size(); j++) {
					int count = 0;
					String combo = "";
					for(int k = 0; k <= i; k++) {
						count += coinVals.get(k);
						combo += "1x" + coinVals.get(k) + "p + ";
					}
					int howMany = numOfCoins(count, coinVals.get(j));
					count += (howMany * coinVals.get(j));
					if(howMany > 0) combo += howMany + "x" + coinVals.get(j) + "p + ";
					if(count == 200) combos.add(combo.substring(0, combo.length() - 3));
				}
			}
			
			coinVals.remove(0);
		}
		for(String combo : combos) {
			System.out.println(combo);
		}
		
		return combos.size();
	}
	
	private static int numOfCoins(int currentCount, int coinVal) {
		int counter = 0;
		int tempCount = currentCount;
		while(tempCount < 200) {
			counter++;
			tempCount += coinVal;
		}
		return counter;
	}
}
