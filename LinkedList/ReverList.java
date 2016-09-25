/**
 * Reverse a linked list. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL,
 * return 5->4->3->2->1->NULL.
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class ReverseList {
    public ListNode reverseList(ListNode a) {
        
        ListNode head = a;
        ListNode prev = null;
        ListNode current = a;
        ListNode next = current.next;
        
        while(current != null) {
            
            current.next = prev;
            prev = current;
            current = next;
            if(current != null) {
                next = next.next;    
            }
            else {
                next = null;
            }
            
        }
     return prev;   
        
    }
}
