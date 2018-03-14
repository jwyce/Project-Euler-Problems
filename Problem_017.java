package euler;

public class Problem_017 {

	static int countLetters() {
	    return countLetters(1000);
	}
	
	private static int countLetters(int n) {
		int letters = 0;

		for(int i =  1; i < n; i++) {
			if(i < 21) {
				letters += getLetters(i);
			} else if(i < 100) {
				letters += getLetters(i / 10 * 10);
				letters += getLetters(i % 10);
			} else {
				letters += getLetters(i / 100) + 7;

				if(i % 100 != 0) {
					letters += 3; 		//covers the x-hundred AND x case
					if(i % 100 < 21) {
						letters += getLetters(i % 100);
					} else {
						letters += getLetters((i % 100) / 10 * 10);
						letters += getLetters(i % 10);
					}
				} 	
			}
		}
		
		return letters + 11;
	}

	private static int getLetters(int number) {
		switch(number) {
			case 1:
			case 2:
			case 6:
			case 10:
				return 3;
			case 4:
			case 5:
			case 9:
				return 4;
			case 3:
			case 7:
			case 8:
			case 40:
			case 50:
			case 60:
				return 5;
			case 11:
			case 12:
			case 20:
			case 30:
			case 80:
			case 90:
				return 6;
			case 15:
			case 16:
			case 70:
				return 7;
			case 13:
			case 14:
			case 18:
			case 19:
				return 8;
			case 17:
				return 9;
			default:
				return 0;
		}
	}

}
