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
    public void reorderList(ListNode head) {
        ListNode fast=head,slow=head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = head;
        ListNode pre=null,curr=fast,post=null;
        while(curr!=null){
            post = curr.next;
            curr.next = pre;
            pre = curr;
            curr = post;
        }
        fast = pre;
        int i=0;
        ListNode dummy = new ListNode(-1);
        dummy.next = slow;
        curr = dummy;
        while(slow!=null || fast!=null){
            if(i%2==0){
                curr.next = slow;
                slow = slow.next;
            }else{
                curr.next = fast;
                fast = fast.next;
            }
            curr = curr.next;
            i++;
        }
        if(fast==null) curr.next = slow;
        else curr.next = fast;
        head = dummy.next;
    }
}