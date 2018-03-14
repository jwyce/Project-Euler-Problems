package euler;

public class Problem_014 {

	static int FindLargestCollatzChain() {
		int longestChainProducer = 0, longestChain = 0;
		
		for(int startNum = 1; startNum < 1000000; startNum++) {
			int currentChain = 1;
			long currentTerm = startNum;
			boolean foundEnd = false;
			
			while(!foundEnd) {
				if(currentTerm % 2 == 0) {
					currentTerm /= 2;
				} else {
					currentTerm = 3 * currentTerm + 1;
				}
				
				foundEnd = currentTerm == 1;
				currentChain++;
			}
			
			if(longestChain < currentChain) {
				longestChain = currentChain;
				longestChainProducer = startNum;
			}
		}
		
		return longestChainProducer;
	}

}
