package euler;

public class Problem_038 {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println(largestPandigitalMultiple());
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}

	private static String largestPandigitalMultiple() {
		String largest = "0";
		
		for(int i = 1; i < 10000; i++) {
			String concat = multipleConcat(i);
			if(isPandigital(concat) && Integer.parseInt(largest) < Integer.parseInt(concat)) {
				largest = concat;
			}
		}
		
		return largest;
	}
	
	private static String multipleConcat(int n) {
		String concat = "";
		int counter = 1;
		
		while(concat.length() < 9) {
			concat += (n * counter++);
		}
		
		return concat;
	}
	
	private static boolean isPandigital(String s) {
		if(s.length() != 9) return false;
        if(s.contains("0")) return false;
        for(int i = 1; i <= 9; i++) {
            if(s.length() - s.replaceAll(Integer.toString(i), "").length() != 1)
                return false;
        }
        // System.out.println(s);
        return true;
    }
}
