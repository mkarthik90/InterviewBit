/*
* Given n non-negative integers representing an elevation map where the width of each bar is 1, 
* compute how much water it is able to trap after raining.
* Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
* https://www.interviewbit.com/problems/rain-water-trapped/
* The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
* In this case, 6 units of rain water (blue section) are being trapped.
*/

public class RainWater {
	// DO NOT MODIFY THE LIST
	public int trap(final List<Integer> a) {
	    
	    
	    List<Integer> leftMaxHeight = new ArrayList<>();
	    List<Integer> rightMaxHeight = new ArrayList<>();
	    int maxValue = Integer.MIN_VALUE;
	    for(int aValue : a) {
	        if(maxValue < aValue) {
	            maxValue = aValue;
	        }
	        leftMaxHeight.add(maxValue);
	    }
	   
	   maxValue = Integer.MIN_VALUE;
	   for(int i=a.size()-1; i>=0;i--) {
	       int aValue = a.get(i);
	       if(aValue > maxValue) {
	           maxValue = aValue;
	       }
	       
	       rightMaxHeight.add(maxValue);
	   }
	    
	   int total = 0;
	   Collections.reverse(rightMaxHeight);
	   
	   for(int i=1; i< a.size() - 1; i++) {
	       int leftHeight = leftMaxHeight.get(i - 1);
	       int rightHeight = rightMaxHeight.get(i + 1);
	       int temp = leftHeight > rightHeight ? rightHeight : leftHeight;
	       
	       if(temp - a.get(i) > 0) {
	           
	           total = total + (temp - a.get(i));
	       }
	   }
	 return total;   
	}
}
