package euler;

import java.util.ArrayList;

public class Problem_002 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println("The answer is " + SumOfEvenFibonacciNums () + ".");
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}

	private static int SumOfEvenFibonacciNums () {
		int sum = 2, currentTerm = 0, index = 3;
		ArrayList<Integer> evenFibonacciNums = new ArrayList<Integer>();
		
		evenFibonacciNums.add(1);
		evenFibonacciNums.add(2);
		
		while(currentTerm < 4000001) {
			currentTerm = evenFibonacciNums.get(index - 3) + evenFibonacciNums.get(index - 2);
			
			if(currentTerm % 2 == 0) {
				sum += currentTerm;
			}
			
			evenFibonacciNums.add(currentTerm);
			index++;
		}
		
		return sum;
	}
	
}
