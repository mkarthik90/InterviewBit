public class SubArraySum {
    // DO NOT MODFIY THE LIST. 
    public int maxSubArray(final List<Integer> array) {
        if(array == null || array.isEmpty()) {
            return 0;
        }
        
        // To check if all the values are negative. If so return the lowest negative value
        boolean positive = false;
        int maximum = Integer.MIN_VALUE;
        for(int a: array) {
            if(a >= 0) {
                positive = true;
                break;
            } 
            else if( maximum < a) {
                maximum = a;
            }
        }
        
        if(!positive) {
            return maximum;
        }
        
        maximum = 0;
        int currentMaximum = 0;
        for(int i=1; i< array.size(); i++) {
            int a = array.get(i);
            currentMaximum = currentMaximum + a;
            
            if(currentMaximum < 0) {
                currentMaximum = 0;
            }
            
            if(maximum < currentMaximum) {
                maximum = currentMaximum;
            }
            
        }
    return maximum;
    }
}
