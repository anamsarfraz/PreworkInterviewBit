package checkpoint5_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.List;

/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 */
public class Solution {
	public int longestConsecutive(final List<Integer> a) {
	    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	    int prev;
	    int next;
	    int currMax = 1;
	    
	    for (int i=0; i < a.size(); i++) {
	        hm.put(a.get(i), 0);
	    }
	    
	    for (int i=0; i < a.size(); i++) {
	        int key = a.get(i);
	        if (hm.get(key) == null || hm.get(key) > 0) {
	            continue;
	        }
	        
	        // Check for a sequence including this key
	        next = a.get(i) + 1;
	        prev = a.get(i) - 1;

	        while (hm.containsKey(prev)) {
	           hm.remove(prev);
	           prev--;
	       }
	       
	       while (hm.containsKey(next)) {
	           hm.remove(next);
	           next++;
	       }
	       
	       hm.put(a.get(i), next-prev-1);
	 
	    }
	    
        Iterator it = hm.entrySet().iterator();
        
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>)it.next();
            if (entry.getValue() > currMax) {
                currMax = entry.getValue();
            } 
        }
        
	    
	    return currMax;
	}
}
