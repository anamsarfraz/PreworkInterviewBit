package checkpoint3_1;

import java.util.ArrayList;
import java.util.List;

/*
 * Find the kth smallest element in an unsorted array of non-negative integers.
 */
public class Solution {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	
	private int kthSmallestElement(final List<Integer> a, int start, int end, int k) {
	    int pivot = a.get(end), pos = start;
	    
	    //System.out.println("Pivot: "+pivot+ "position: "+pos);
	      // Pivot around last element
         for (int i = start; i <= end - 1; i++) {
             if (a.get(i) < pivot) {
                 int temp = a.get(pos);
                 a.set(pos, a.get(i));
                 a.set(i, temp);
                 pos++;
             } else if (a.get(i) == pivot) {
                 
             }
        }
        int temp = a.get(pos);
        a.set(pos, a.get(end));
        a.set(end, temp);
        
        // If position is same as k
        if (pos-start == k-1)
            return a.get(pos);
        if (pos-start > k-1) {
            return kthSmallestElement(a, start, pos-1, k);
        } else {
            return kthSmallestElement(a, pos+1, end, k-1-(pos-start));
        }

    }
    
    
	
	public int kthsmallest(final List<Integer> a, int k) {
	    
	    ArrayList<Integer> result = new ArrayList<Integer>(a);
	    return kthSmallestElement(result, 0, a.size() - 1, k);
	    
	}
}
