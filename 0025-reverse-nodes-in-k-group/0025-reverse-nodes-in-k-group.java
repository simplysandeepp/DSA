class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode sec = head;
        
        for (int i = 0; i < k; i++) {
            if (sec == null) return head; // yaha or k nodes nhi bache hai 
            sec = sec.next;
        }
        
        ListNode newHead = rev(head, sec);
        head.next = reverseKGroup(sec, k);
        
        return newHead;
    }

    public ListNode rev(ListNode head, ListNode stop) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        
        while (curr != stop) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; // poiting to the next node
        }
        return prev;
    }
}