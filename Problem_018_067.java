package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Problem_018_067 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println(bruteForceSearch(getTriangle()));
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}
	
	private static String bruteForceSearch(ArrayList<String[]> triangle) {
		for(int level = triangle.size() - 1; level > 0; level--) {			// start from bottom to top
			String[] parentNodes = triangle.get(level - 1);
			String[] nodes = triangle.get(level);
			for(int node = 0; node < nodes.length - 1; node++) {			// add biggest child to parent
				if(Integer.parseInt(nodes[node]) > Integer.parseInt(nodes[node + 1])) {
					parentNodes[node] = Integer.toString(Integer.parseInt(parentNodes[node]) + Integer.parseInt(nodes[node]));
				} else {
					parentNodes[node] = Integer.toString(Integer.parseInt(parentNodes[node]) + Integer.parseInt(nodes[node + 1]));
				}
			}
			triangle.set(level - 1, parentNodes);							// set new parents
		}
		
		return triangle.get(0)[0];
	}
	
	private static ArrayList<String[]> getTriangle() {
		ArrayList<String[]> triangle = new ArrayList<String[]>(500);
		String line = "";
		
		try(BufferedReader reader = new BufferedReader(new FileReader(new File("p067_triangle.txt")))) {
			while((line = reader.readLine()) != null) {
				triangle.add(line.split(" "));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return triangle;
	}

}
