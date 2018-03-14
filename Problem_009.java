package euler;

public class Problem_009 {

	static int FindSpecialPytagoreanTripleProduct() {
		int product = 0;
		
		search:
		for(int c = 5; c < 1000; c++) {
			for(int b = 4; b < 1000; b++) {
				for(int a = 3; a < 1000; a++) {
					if((a * a) + (b * b) == c * c) {
						if(a + b + c == 1000) {
							product = a * b * c;
							break search;
						}
					}
				}
			}
		}
		return product;
	}

}
