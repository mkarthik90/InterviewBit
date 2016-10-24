/**
 * Find out the maximum sub-array of non negative numbers from an array.
 * The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).
 * 
 * Example
 * 
 * A : [1, 2, 5, -7, 2, 3]
 * The two sub-arrays are [1, 2, 5] [2, 3].
 * The answer is [1, 2, 5] as its sum is larger than [2, 3]
 * 
 * NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
 * NOTE 2: If there is still a tie, then return the segment with minimum starting index
 */

class MaxNonNegative {
    public ArrayList<Integer> maxset(ArrayList<Integer> array) {
        
        Long maximumSum = new Long(-1);
        ArrayList<Integer> returnList = new ArrayList<>();
        Long currentSum = new Long(0);
        ArrayList<Integer> currentList = new ArrayList<>();
        for(int i=0; i<array.size(); i++) {
            int a = array.get(i);
            if (a < 0) {
                currentSum = new Long(0);
                currentList = new ArrayList<>();
            } else {
                currentSum = currentSum + a;
                currentList.add(a);
            }
            
            if(maximumSum == currentSum && currentList.size() >= returnList.size()) {
                maximumSum = currentSum;
                returnList = new ArrayList<>(currentList);
            }
            else if (maximumSum < currentSum) {
                maximumSum = currentSum;
                returnList = new ArrayList<>(currentList);
            }
        }
        
        return returnList;
    }
}