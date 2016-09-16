/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * 
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Rotation {

	public ListNode rotateRight(ListNode a, int b) {
	    
	    ListNode temp = a;
	    ListNode head = a;
	    ListNode newHead = a;
	    ListNode prev = null;
	    int totalSize = 0;
	    while(temp != null) {
	        temp = temp.next;
	        totalSize++;
	    }
	    
	    // To reduce many rotations
	    if(b != 0) {
	        b = b % totalSize;	        
	    }

	    
	    if(b == 0) {
	        return newHead;
	    }
	    // To get the distance of the node to be moved from the head position.
	    // b value currently contains the distance of the node from the back position.
	    b = totalSize - b;
	    temp = a;
	    while(temp != null && b!=0) {
	        b--;
	        prev = temp;
	        temp = temp.next;
	    }
	    
	    if(prev == null) {
	        return a;
	    }
	    
	    prev.next = null;
	    newHead = temp;
	    while(temp.next != null) {
	        temp = temp.next;
	    }
	    temp.next = head;
	    
	    return newHead;
	}
}
