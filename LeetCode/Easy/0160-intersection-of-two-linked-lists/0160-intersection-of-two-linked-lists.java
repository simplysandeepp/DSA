public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) {
            return null;
        }
        ListNode fast=headA;
        ListNode slow=headB;
        while (fast !=slow ) {
            fast=(fast==null)?headB:fast.next;
            slow=(slow==null)?headA:slow.next;
        }
        return fast;
    }
}