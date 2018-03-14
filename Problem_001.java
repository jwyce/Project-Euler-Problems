package euler;

public class Problem_001 {
	
	static int SumMultiplesOf3Or5() {
		int sum = 0;
		
		for(int num = 1; num < 1000; num++) {
			if(num % 5 == 0 || num % 3 == 0) {
				sum += num;
			}
		}
		
		return sum;
	}

}
