/**
 * Definition for singly-linked list. 
 * You are given two linked lists representing two non-negative numbers. 
 *  The digits are stored in reverse order and each of their nodes contain a single digit. 
 *  Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 */

class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
 }
 
public class AddList {
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode last = new ListNode(0);
        ListNode head = last;
        int carry = 0;
        while(a != null && b != null) {
            int sum = a.val + b.val + carry;
            int result = 0;
            a = a.next;
            b = b.next;
            
            
            if(sum/10 > 0) {
                // There is a carry
                result = sum % 10;
                carry = sum / 10;
            } else {
                result = sum;
                carry = 0;
            }
            last = insertAtLast(last, result);
        }
        
        while(a != null) {
            int sum = a.val + carry;
            int result = 0;
            if(sum/10 > 0) {
                // Ther is carry
                result = sum % 10;
                carry = sum / 10;
            } else {
                result = sum;
                carry = 0;
            }
            last = insertAtLast(last, result);
            a = a.next;
        }
        
        while(b != null) {
            int sum = b.val + carry;
            int result = 0;
            if(sum/10 > 0) {
                // Ther is carry
                result = sum % 10;
                carry = sum / 10;
            } else {
                result = sum;
                carry = 0;
            }
            last = insertAtLast(last, result);
            b = b.next;
        }
        
        if(carry != 0) {
            last = insertAtLast(last, carry);
        }
    return head.next;
    }
    
    public ListNode insert(ListNode node, int result) {
        ListNode temp = node;
        if(node == null) {
            node = new ListNode(result);
            node.next = null;
            return node;
        }
        
        while(node.next != null) {
            node = node.next;
        }
        // insert at last       
        node.next = new ListNode(result);
        return temp;
    }
    
    public ListNode insertAtLast(ListNode last, int result) {
        
        if(last == null) {
            // This is the first node
            last = new ListNode(result);
            return last;
        }
        
        // Else insert last
        last.next = new ListNode(result);
        return last.next;
    }
}
