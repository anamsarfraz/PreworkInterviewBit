package checkpoint2;

import java.util.ArrayList;

/*
 * Print concentric rectangular pattern in a 2d matrix.
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    
	    int size = (2*a) - 1;
	    
	    for (int i = 0; i < size; i++) {
	        result.add(new ArrayList<Integer>());
	        
	        for (int j=0; j < size; j++) {
	            result.get(i).add(0);
	        }
	    }
	    
	    int rowStart = 0;
	    int rowEnd = size-1;
	    int colStart = 0;
	    int colEnd = size-1;
	    
	    
	    while (rowStart <= rowEnd && colStart <= colEnd) {
	        for (int i = colStart; i <= colEnd; i++) {
	            result.get(rowStart).set(i, a);
	        }
	        
	        rowStart++;
	        
	        for (int i = rowStart; i <= rowEnd; i++) {
	            result.get(i).set(colEnd, a);
	        }
	        
	        colEnd--;
	        
	        for (int i = colEnd; i >= colStart; i--) {
	            result.get(rowEnd).set(i, a);
	        }
	        
	        rowEnd--;
	        
	        for (int i = rowEnd; i >= rowStart; i--) {
	            result.get(i).set(colStart, a);
	        }
	        
	        colStart++;
	        
	        a--;
	    }
	    
	    return result;
	}
}
