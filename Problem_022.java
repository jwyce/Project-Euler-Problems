package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem_022 {
	
	static int nameScoreSum() {
		PriorityQueue<String> names = getNames();		// min heap
		int sum = 0;
		int index = 1;
		
		while(! names.isEmpty()) {
			String name = names.poll();					// get and remove min (serves as simultaneous sort)
			int nameVal = 0;
			for(int i = 0; i < name.length(); i++) {	// get int sum of char ascii values
				nameVal += ((int) name.charAt(i) - 64);
			}
			sum += index * nameVal;
			index++;
		}
		
		return sum;
	}
	
	private static PriorityQueue<String> getNames() {
		String names = "";
		
		try(BufferedReader reader = new BufferedReader(new FileReader(new File("p022_names.txt")))) {
			names = reader.readLine();
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		return new PriorityQueue<String>(Arrays.asList(names.replaceAll("\"", "").split(",")));
	}

}
