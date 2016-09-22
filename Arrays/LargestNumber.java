/*
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example:
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * https://www.interviewbit.com/problems/largest-number/ 
*/

import java.math.BigInteger;
public class largestNumber {
    
    // DO NOT MODIFY THE LIST
    
    private int array[];
    private int length;
    
    public String largestNumber(final List<Integer> list) {

        List<Node> nodes = new ArrayList<>();
        for (Integer i : list) {
            Node n = new Node(i);
            nodes.add(n);
        }

        Collections.sort(nodes);

        StringBuilder builder = new StringBuilder();
        for (Node node : nodes) {
            // This has been added in order
            if(node.val == 0 && builder.length() == 0) {
                continue;
            }
            builder.append(node.val);
        }

        return builder.toString();
    }

    public class Node implements Comparable<Node> {
        int val;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public int compareTo(Node n) {
            StringBuffer buffer = new StringBuffer("");
            buffer.append(n.val);
            buffer.append(this.val);

            StringBuffer buffer2 = new StringBuffer("");
            buffer2.append(this.val).append(n.val);

            return buffer.toString().compareTo(buffer2.toString());
        }

    }



}
