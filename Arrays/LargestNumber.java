/*
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example:
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * https://www.interviewbit.com/problems/largest-number/ 
*/

import java.math.BigInteger;
public class LargestNumber {
    // DO NOT MODIFY THE LIST
    
    private int array[];
    private int length;
    
    public String largestNumber(final List<Integer> list) {
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        
        sort(a);
        
        String result = "";
        
        for (int k : array) {
            result += String.valueOf(k);
        }
        
        while(result.startsWith("0")){
            result = result.substring(1, result.length());
        }
        
        if(result.isEmpty()) {
            result = "0";
        }
        
        return result;
    }


    public static int compare(int a, int b) {
        // 0 Equal
        // -1 - a > b
        // 1 - a < b
        String a1 = String.valueOf(a);
        String b1 = String.valueOf(b);

        String result1 = a1 + b1;
        String result2 = b1 + a1;

        BigInteger r1 = new BigInteger(result1);
        BigInteger r2 = new BigInteger(result2);

        if (r2.compareTo(r1) == -1) {
            return -1;
        } else if (r2.compareTo(r1) == 1) {
            return 1;
        }

        return 0;
    }

    public void sort(int[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (compare(array[i], pivot) == -1) {
                i++;
            }
            while (compare(array[j], pivot) == 1) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
