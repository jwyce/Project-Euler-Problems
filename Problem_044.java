package euler;

import java.util.ArrayList;

public class Problem_044 {

	static int minPentaNumDiff() {
		int minDiff = Integer.MAX_VALUE;
		ArrayList<Integer> p = new ArrayList<Integer>();
		for (int n = 1; n < 2500; n++) {
			p.add((3*n*n - n)/2);
		}
		
		for(int i = 0; i < p.size(); i++) {
			for(int j = i; j < p.size(); j++) {
				int d = Math.abs(p.get(i) - p.get(j));
				if(p.contains(p.get(i) + p.get(j)) && p.contains(d)) {
					if(minDiff > d) minDiff = d;
				}
			}
		}
		
		return minDiff;
	}
}
