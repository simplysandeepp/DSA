/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        int l = 1; //head and length;
        ListNode tail = head;
        while(tail.next != null) {
            tail = tail.next;
            l++;
        }
        k = k%l;
        if(k==0) return head;
        // circular  conenect
        tail.next = head;
        int remain = l-k;
        ListNode newTail = head;
        for(int i=1; i<remain; i++){
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}