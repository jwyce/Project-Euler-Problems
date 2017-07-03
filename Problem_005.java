package euler;

public class Problem_005 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println("The smallest number evenly divisable by 1 through 20 is " + intDivisableBy1Thru20 () + ".");
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}
	
	private static int intDivisableBy1Thru20() {
		int possibleSolution = 2560;
		boolean conditionSatisfied = false;
		
		while(!conditionSatisfied) {
			for(int i = 3; i < 21; i++) {
				if(possibleSolution % i != 0) {
					possibleSolution += 10;
					break;
				}
				conditionSatisfied = i == 20;
			}
		}
		
		return possibleSolution;
	}
	
}
