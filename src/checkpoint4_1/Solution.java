package checkpoint4_1;


/*
 * Given a singly linked list, modify the value of first half nodes such that :

 * 1st node’s new value = the last node’s value - first node’s current value
 * 2nd node’s new value = the second last node’s value - 2nd node’s current value,
 * and so on …
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode subtract(ListNode a) {
	    ListNode rev, fwd;
	    int length = 0;
	    
	    if (a == null) {
	        return a;
	    } 
	    fwd = a;
	    rev = a;
        length++;

        while (fwd != null && fwd.next != null) {
            fwd = fwd.next;
            length++;
            if (fwd.next != null) {
                fwd = fwd.next;
                rev = rev.next;

                length++;
            }
        }
        
        fwd = rev.next;
        
        ListNode currNode = a, prevNode = null, nextNode = null;
        
        //System.out.println("Rev node val: "+rev.val+", Fwd node val: "+fwd.val+", length: "+length);
        //System.out.println("Rev node: "+rev.next);
        while(currNode != fwd){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            
            //System.out.println("Curr node: "+currNode+" eval: "+(currNode == rev));
             
            //System.out.println("currNode val : "+currNode.val+", nextNode val: "+nextNode.val+", prevNode val: "+prevNode.val);
        }
        
        nextNode = fwd;
        
        if (length%2 == 1) {
            prevNode = rev.next;
        }
        
        while (prevNode != null && nextNode != null) {
            prevNode.val = nextNode.val - prevNode.val;
            prevNode = prevNode.next;
            nextNode = nextNode.next;
        }
        
        currNode = rev;
        prevNode = fwd;
        nextNode = null;
        
        while(currNode != null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        
        return a;
	    
	}
}
