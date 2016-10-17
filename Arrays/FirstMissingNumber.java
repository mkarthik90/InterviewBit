/**
* https://www.interviewbit.com/problems/first-missing-integer/
**/
class FirstMissingNumber {

    public int firstMissingPositive(List<Integer> a) {
        
        // First remove all the negative numbers
        for (int i = 0; i < a.size(); i++) {
            Integer temp = a.get(i);
            if (temp <= 0) {
                // Remove this entry
                a.remove(i);
            }
        }

        // Place each entry in its position
        for (int i = 0; i < a.size(); i++) {

            Integer temp = a.get(i);
            temp = Math.abs(temp);
            if (temp <= a.size() - 1) {
                Integer changeValue = a.get(temp);
                if (changeValue > 0) {
                    changeValue = changeValue * -1;
                    a.set(temp, changeValue);
                }
            }

        }
        
        for (int i = 1; i < a.size(); i++) {
            Integer temp = a.get(i);
            if (temp > 0) {
                return i;
            }
        }

        return a.size() + 1;
    }
}