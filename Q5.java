public class Q5 {
    public boolean hasCycle(ListNode head) {
       
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        while(fast.next!=slow){
            fast=fast.next;
        }
        fast.next=null;
        return false;
    }
}