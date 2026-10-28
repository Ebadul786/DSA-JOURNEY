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
        if(head==null || head.next==null) return head;
        int n=0;
        ListNode temp = head;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        k = k%n;
        if(k==0) return head;
        ListNode slow=head,fast=head;
        for(int i=1;i<=k;i++) fast = fast.next;
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        temp = head;
        head = slow.next;
        slow.next = null;
        fast.next = temp;
        return head;
    }
}