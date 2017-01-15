package checkpoint3_2;

import java.util.ArrayList;

/*
 * Given an array of non negative integers A, and a range (B, C), 
 * find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C

 * Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
 * where 0 <= i <= j < size(A)
 */
public class Solution {
	public int numRange(ArrayList<Integer> a, int b, int c) {
	    int runningSum = 0;
	    int numSubSequence = 0;
	    int prefixSum = 0;
	    int lo = 0, hi = 0;
	    
	    

	    
	    ArrayList<Integer> prefixSums = new ArrayList<Integer>();
	    prefixSums.add(prefixSum);
	    
	    
	    
	    for (int i= 0; i < a.size(); i++) {
	        prefixSum += a.get(i);
	        prefixSums.add(prefixSum);
	    }
	    
	    
	    
	    
	    for (int i = 0; i < a.size(); i++) {
	        while (lo != a.size()+1 && (prefixSums.get(lo) - prefixSums.get(i) < b))  {
                if (prefixSums.get(lo) - prefixSums.get(i) < 0 && b == 0) {
                    numSubSequence -= 1;
                }
	            lo += 1;
	        }
        
            while (hi != a.size()+1 && (prefixSums.get(hi) - prefixSums.get(i) <= c)) {
                if (i == 0 && hi == 0 && c== 0) {
                    numSubSequence -= 1;
                }
                hi += 1;
            }
            
            //System.out.println("hi: "+hi +", lo: "+lo);
            numSubSequence += (hi - lo);

	    }
	    
	    return numSubSequence;
	}
}
