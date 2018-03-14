package euler;

public class Problem_005 {

	static int intDivisableBy1Thru20() {
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
