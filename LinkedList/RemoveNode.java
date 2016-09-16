/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
**/
public class RemoveNode {
    public ListNode removeNthFromEnd(ListNode a, int b) {
	    
	    // Find size of the linkedlist
	    ListNode temp = a;
	    ListNode prev = a;
	    int totalSize = 0;
	    while(temp != null) {
	        temp = temp.next;
	        totalSize++;
	    }
	    
	    if(b >= totalSize) {
	        // Remove first
	        return a.next;
	    }
	    
	    // Else remove the nth node
	    
	    int c = totalSize - b ;
	    temp = a;
	    while(c >0 && temp != null) {
	        c--;
	        prev = temp;
	        temp = temp.next;
	    }
	    // Temp node is the last node
	    
	    if(temp == null) {
	        prev.next = null;
	        return a;
	    }
	    
	    prev.next = temp.next;
	    return a;
	}
}