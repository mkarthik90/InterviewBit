/**
 * This function reverses the node from the start position m
 * and the end position n
**/
class ReverseListII {

    public ListNode reverseBetween(ListNode a, int m, int n) {
        
        ListNode temp = a;
        ListNode previous = null;
        n = n - m;
        while(m>1 && a!= null){
            previous = a;
            a = a.next;
            m--;
        }       
        
        if(a == null) {
            return temp;
        }
        
        ListNode current  = a;
        ListNode next = a.next;
        ListNode t = null;
        ListNode firstNode = current;
        // start reversing
        while(n >= 1 && next != null) {
            n--;
            if(next != null) {
                t = next.next;
            }
            next.next = current;
            current = next;
            next = t;
        }
        firstNode.next = next;
        if(previous != null) {
            previous.next = current;
            return temp;
        }

        return current;
    }
    
}