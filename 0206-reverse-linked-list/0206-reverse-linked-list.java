class Solution {
    public ListNode reverseList(ListNode head) {
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
}