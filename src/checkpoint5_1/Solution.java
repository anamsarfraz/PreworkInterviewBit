package checkpoint5_1;

import java.util.Collections;
import java.util.ArrayList;

/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        Collections.sort(a);
        result.add(new ArrayList<Integer>());
        result.get(0).add(a.get(0));
        
        for (int i = 1; i < a.size(); i++) {

            int resultSize = result.size();
            for (int j= resultSize -1; j >= 0; j--) {
                ArrayList<Integer> permutation = result.remove(j);
                for (int k=0; k <= permutation.size(); k++) {
                    ArrayList<Integer> newPermutation = new ArrayList<Integer>(permutation);
                    newPermutation.add(k, a.get(i));

                    result.add(newPermutation);
                    if (a.get(i) == a.get(i-1) && newPermutation.get(k) == newPermutation.get(k+1)) {
                        break;
                    }
                    
                   

                }
            }
        }

        return result;
	}
}
