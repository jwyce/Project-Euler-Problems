package euler;

import java.util.HashMap;
import java.util.Iterator;

public class Problem_033 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		System.out.println(simpleDenomProduct());
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}
	
	private static int simpleDenomProduct() {
		HashMap<Integer, Integer> curiousFractions = get2DigitCuriousFractions();
		Iterator<Integer> itr = curiousFractions.keySet().iterator();
		int num = 1, denom = 1;
		
		while (itr.hasNext()) {
			int numerator = itr.next();
			num *= numerator;
			denom *= curiousFractions.get(numerator);
		}
		
		// System.out.println(num + "/" + denom);
		return denom / GCD(num, denom);
	}
	
	private static int GCD(int num1, int num2){
		if(num2 == 0) return num1;
		else return GCD(num2, num1 % num2);
	}
	
	private static HashMap<Integer, Integer> get2DigitCuriousFractions() {
		HashMap<Integer, Integer> curiousFractions = new HashMap<Integer, Integer>();
		
		for (int num = 11; num < 100; num++) {
			if (num % 10 == 0) continue;
			String numStr = Integer.toString(num);
			for (int denom = num + 1; denom < 100; denom++) {
				if (denom % 10 == 0) continue;
				if (num / denom >= 1) break;
				String denomStr = Integer.toString(denom);
				if ((double) num / denom == digitCancel(numStr, denomStr))
					curiousFractions.put(num, denom);
			}
		}
		
		return curiousFractions;
	}
	
	private static double digitCancel(String num, String denom) {
		for (int i = 0; i < denom.length(); i++) {
			if (num.contains(denom.substring(i, i + 1))) {
				num = num.replaceFirst(denom.substring(i, i + 1), "");
				denom = denom.replaceFirst(denom.substring(i, i + 1), "");
				return (double) Integer.parseInt(num) / Integer.parseInt(denom);
			}
		}
		return 0;
	}
}
