
/*
 * Given a sorted array of integers, find the number of occurrences of a given target value.
 * Your algorithm’s runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return 0

**Example : **
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return 2.
*/

public class FirstOccurence {
    // DO NOT MODIFY THE LIST
    public int findCount(final List<Integer> a, int b) {

        Integer[] myArray = a.toArray(new Integer[a.size()]);
        
        int firstOccurence = firstOccurence(myArray, b, true);
        int lastOccurence = firstOccurence(myArray, b, false);
        // totalOccurence
        if (firstOccurence == -1 || lastOccurence == -1) {
            return 0;
        }
        else {
            int totalOccurence = (lastOccurence - firstOccurence) + 1;
            return totalOccurence;
        }
        
    }

    public int firstOccurence(Integer[] array, int element, boolean firstOccurence) {
        
        int low = 0;
        int high = array.length - 1;
        int result = -1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;

            if (array[mid] == element) {
                // element found find the first element
                result = mid;
                if (firstOccurence) {
                    high = mid - 1;
                } else {
                    // Finding the last occurence
                    low = mid + 1;
                }
            }

            if (array[mid] < element) {
                low = mid + 1;
            }

            if (array[mid] > element) {
                high = mid - 1;
            }

        }
        
        return result;
    }
}
