package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;



public class MinimumAbsoluteDifference {

	
	public static void main(String[] args) {

		
		
		
	}
	
	
	 static int minimumAbsoluteDifference(List<Integer> arr) {


		 Collections.sort(arr);
		 
		 int tempRes = 0;
		 int minimum = Math.abs(arr.get(0) - arr.get(1));
		 
		 for(int i=2; i<arr.size();i++) {
			 
			 tempRes = Math.abs(arr.get(i-1) - arr.get(i));
			 
			 if(tempRes < minimum) {
				 minimum = tempRes; 
			 }
			 
		 }

		 return minimum;
	    }
	 
	 
	 
	 
	 
	 
	 
	 public static List<Integer> convertTextToList(String s) {
		
		
		String[] b = s.split(" ");
		List<Integer> f = new ArrayList<>();
		for(String i: b) {
			
			f.add(Integer.parseInt(i));
		}

		return f;
	 }
		
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
