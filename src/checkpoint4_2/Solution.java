package checkpoint4_2;

import java.util.ArrayList;
import java.util.Stack;

/*
 Given an array, find the next greater element G[i] for every element A[i] in the array. The Next greater Element for an element A[i] is the first greater element on the right side of A[i] in array. 
More formally,

G[i] for an element A[i] = an element A[j] such that 
    j is minimum possible AND 
    j > i AND
    A[j] > A[i]
Elements for which no greater element exist, consider next greater element as -1.
 */
public class Solution {
    
    public class Element {
        int val;
        int index;
        
        public Element(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
	public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
	    Stack<Element> stack = new Stack<Element>();
	    Element elem;
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    for (int i = 0; i < a.size(); i++) {
	        result.add(-1);
	    }
	    
	    stack.push(new Element(a.get(0), 0));
	    
	    for (int i=1; i < a.size(); i++) {
	        
	        if (!stack.empty()) {
	            elem = stack.pop();
    	        while (a.get(i) > elem.val) {
    	            result.set(elem.index, a.get(i));
    	            if (stack.empty()) {
    	                break;
    	            }
    	            
    	            elem = stack.pop();
    	        }
    	        
    	        if (elem.val >= a.get(i)) {
    	            stack.push(elem);
    	        }
	        
	        }
	        
	        stack.push(new Element(a.get(i), i));
	        
	    }
	    
	    return result;
	}
}

