/*Write a function to find the longest common prefix string amongst an array of strings.
 * Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
 * As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 * Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.
 * Given the array as:
 * "abcdefgh",
 *  "aefghijk",
 * "abcefgh"
 * The answer would be “a”.
*/

class LCP {

    public String longestCommonPrefix(ArrayList<String> array) {
        

        if (array.size() == 0) {
            return null;
        }

        if (array.size() == 1) {
            return array.get(0);
        }
        int minLength = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < array.size(); i++) {
            String a = array.get(i);
            if (a.length() < minLength) {
                minLength = a.length();
                minIndex = i;
            }
        }

        String smallestString = array.get(minIndex);
        StringBuilder common = new StringBuilder();
        boolean failed = false;
        for (int i = 0; i < smallestString.length() && failed == false; i++) {
            char c = smallestString.charAt(i);
            for (String s : array) {
                char s1 = s.charAt(i);
                if (c == s1) {
                    continue;
                } else {
                    failed = true;
                    break;
                }
            }
            if(!failed) {
                common.append(c);    
            }
            
        }
        return common.toString();
            
    }
}