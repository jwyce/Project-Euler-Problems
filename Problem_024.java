package euler;

import java.util.ArrayList;
import java.util.Collections;

public class Problem_024 {
	
	static String getLexographicPermutations() {
		ArrayList<String> perms = new ArrayList<String>();
		perms.add("01");
		perms.add("10");
		
		for(int i = 2; i < 10; i++) {
			ArrayList<String> next = new ArrayList<String>(perms);
			perms.clear();
			for(int j = 0; j <= i; j++) {
				for(int k = 0; k < next.size(); k++) {
					perms.add(new StringBuilder(next.get(k)).insert(j, i).toString());
				}
			}
		}
	
		Collections.sort(perms);
		return perms.get(999999);
	}

}
