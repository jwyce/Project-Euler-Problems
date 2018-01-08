package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem_042 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		System.out.println(numberOfTriangleWords(getWords()));
		
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + (endTime - startTime) + " ms.");
	}
	
	private static int numberOfTriangleWords(PriorityQueue<String> words) {
		int triangleWordCount = 0;
		
		while (! words.isEmpty()) {
			String word = words.poll();
			int wordVal = 0;
			
			for (int i = 0; i < word.length(); i++) {
				wordVal += ((int) word.charAt(i) - 64);
			}
			
			int triangleNum = 0;
			for (int n = 1; triangleNum <= wordVal; n++) {
				triangleNum = (n*n + n)/2;
				if (triangleNum == wordVal) triangleWordCount++;;
			}
		}
		
		return triangleWordCount;
	}
	
	private static PriorityQueue<String> getWords() {
		String words = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(new File("p042_words.txt")))) {
			words = reader.readLine();
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		return new PriorityQueue<String>(Arrays.asList(words.replaceAll("\"", "").split(",")));
	}
}
