class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode pre=null,curr,post;
        while(head!=null){
            post = head.next;
            curr = head;
            curr.next=pre;
            pre=curr;
            head = post;
        }
        return pre;
    }
}