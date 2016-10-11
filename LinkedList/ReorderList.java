class ReorderList {
        public ListNode reorderList(ListNode a) {
        // First reverse the second half
        
        if(a.next == null) {
            return a;
        }
        
        ListNode slowPointer = a;
        ListNode fastPointer = a;
        ListNode previous = null;
        while(fastPointer.next != null && fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            previous = slowPointer;
            slowPointer = slowPointer.next;
        }
        
        // Now slow pointer is in mid start reversing
        previous = slowPointer;
        ListNode current = slowPointer.next;
        ListNode next = current.next;
        current.next = null;
        while(next != null) {
            ListNode temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }
        
        // Now point previous to current
        previous.next = current;
        // Now go to mid again which previous.next
        // ListNode b = a;
        // while(b != null) {
        //    System.out.println(b.val+"->");
        //    b = b.next;
        // }
        
        //System.out.println("Previous--"+previous.val);
        //System.out.println("Mid--"+previous.next.val);
        ListNode tempLast = previous;
        ListNode mid = previous.next;
        ListNode head = a;
        ListNode last = null;
        while(mid != null) {
            ListNode tempHead = head.next;
            ListNode tempMid = mid.next;
            head.next = mid;
            mid.next = tempHead;
            if(tempMid == null) {
                last = mid;
            }
            mid = tempMid;
            head = tempHead;
        }
        //System.out.println("headval"+head.val);
        if(tempLast == head) {
            head.next = null;
        } else {
            last.next = null;    
        }
        
        
    return a;   
    }
}