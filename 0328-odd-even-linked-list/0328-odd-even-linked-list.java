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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode temp=head,temp_odd=odd,temp_even=even;
        int i=1;
        while(temp!=null){
            if(i%2!=0){
                temp_odd.next = temp;
                temp_odd = temp_odd.next;
            }else{
                temp_even.next = temp;
                temp_even = temp_even.next;
            }
            temp = temp.next;
            i++;
        }
        temp_even.next = null;
        temp_odd.next = even.next;
        return odd.next;
    }
}