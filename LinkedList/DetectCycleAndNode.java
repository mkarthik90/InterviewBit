/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Try solving it using constant additional space.
 * Example :
 * Definition for singly-linked list.
 *Input : 
 *
 *                  ______
 *                 |     |
  *                \/    |
 *         1 -> 2 -> 3 -> 4
 * Return the node corresponding to node 3. 
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class DetectCycleAndNode {
    public ListNode detectCycle(ListNode a) {
        
        ListNode slowPointer = a;
        ListNode fastPointer = a;
        
        boolean bothMet = false;
        while(slowPointer != null && fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if(slowPointer == fastPointer) {
                bothMet = true;
                break;
            }
        }
        
        if(bothMet) {
            fastPointer = a;
            while(fastPointer != null && slowPointer != null) {
                if(slowPointer == fastPointer) {
                    return slowPointer;
                }
                fastPointer = fastPointer.next;
                slowPointer = slowPointer.next;
            }
        }
        return null;
        
    }
}
