package todoapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Algorithm {
	 public List<List<Integer>> increasingSubArrays(int[] array) {

	        List<List<Integer>> allSubArray = new ArrayList<>();
	        
	        if (array == null || array.length == 0) 
	        	return allSubArray;

	        int i = 0;

	        while (i < array.length) {

	            List<Integer> SubArray = new ArrayList<>();
	            SubArray.add(array[i]);

	            int end = i;
	            while (end + 1 < array.length && array[end] < array[end + 1]) {
	                SubArray.add(array[end + 1]);
	                end++;
	            }

	            allSubArray.add(SubArray);

	            i = end + 1;  
	        }

	        return allSubArray;
	    }
	


}
