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
    static ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode pre=null,curr=head,post;
        while(curr!=null){
            post = curr.next;
            curr.next = pre;
            pre = curr;
            curr = post;
        }
        return pre;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }
        int count = 1;
        ListNode temp = head,a=null,b=null,c=null,d=null;
        while(temp!=null){
            if(count==left-1) a = temp;
            if(count==left) b = temp;
            if(count==right) c = temp;
            if(count==right+1) d = temp;
            count++;
            temp = temp.next;
        }
        if(a!=null) a.next = null;
        else head = b;
        c.next = null;
        b = reverse(b);
        temp = b;
        while(temp.next!=null) temp = temp.next;
        c = temp;
        if(a!=null) a.next = b;
        c.next = d;
        if(a!=null) return head;
        else return b;
    }
}