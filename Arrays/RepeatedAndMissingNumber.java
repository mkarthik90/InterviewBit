//You are given a read only array of n integers from 1 to n.
//
//Each integer appears exactly once except A which appears twice and B which is missing.
//
//Return A and B.
//
//Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//Note that in your output A should precede B.
//Input:[3 1 2 5 3] 
//
//Output:[3, 4] 
//
//A = 3, B = 4
// https://www.interviewbit.com/problems/repeat-and-missing-number-array/

class RepeatedAndMissingNumber {
    public ArrayList<Integer> repeatedNumber(final List<Integer> t) {
        
        List<Integer> a = new ArrayList<Integer>(t);
        for(int i=0; i<a.size(); i++) {
            int n = a.get(i);
            if(n < 0) {
                continue;
            }
            n = n-1;
            if(a.get(n) > 0) {
                // This is the first occurence so swap the data
                a.set(i, a.get(n));
                a.set(n, -1);
                i--;
            } 
            else {
                // Since value is negative add -1 and move to the next element
                int temp = a.get(n);
                a.set(n, temp-1);
                
            }
        }
        
        ArrayList<Integer> output = new ArrayList<>();
        int repeatNumber = 0;
        int missingNumber = 0;
        for(int i=0; i<a.size(); i++) {
            if(a.get(i) < -1) {
                repeatNumber = i + 1;
            }
            if(a.get(i) > 0) {
                missingNumber = i + 1;
            }
        }
        
        output.add(repeatNumber);
        output.add(missingNumber);
        
        return output;
    }
}
}