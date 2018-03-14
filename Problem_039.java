package euler;

import java.util.ArrayList;

public class Problem_039 {
	
	static int maxPerimeterSoultions() {
	    return maxPerimeterSoultions(1000);
	}
	
	private static int maxPerimeterSoultions(int upperbound) {
		int p = 0;
		int maxSolutions = 0;
		
		for(int perimeter = 12; perimeter <= upperbound; perimeter++) {
			int solutions = numberOfRightTriangles(perimeter);
			if(maxSolutions < solutions) {
				maxSolutions = solutions;
				p = perimeter;
			}
		}
		
		return p;
	}
	
	private static int numberOfRightTriangles(int perimeter) {
		ArrayList<String> triangles = new ArrayList<String>(perimeter);
		
		for(int a = 1; a < perimeter; a++) {
			for(int b = a + 1; a + b < perimeter; b++) {
				int c = (int) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
				if(a + b + c == perimeter && a*a + b*b == c*c)
					triangles.add("{" + a + "," + b + "," + c + "}");
			}
		}
		
		// System.out.println(triangles.toString());
		
		return triangles.size();
	}
}
