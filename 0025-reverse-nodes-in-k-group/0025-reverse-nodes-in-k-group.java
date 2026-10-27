class Solution {
    static ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode pre = null, curr = head, post;

        while(curr != null) {
            post = curr.next;
            curr.next = pre;
            pre = curr;
            curr = post;
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode a = dummy, b, c, d;

        while(a.next != null) {
            b = a.next;
            c = b;

            // Find kth node
            int count = 1;
            while(count < k && c != null) {
                c = c.next;
                count++;
            }

            // Fewer than k nodes remaining
            if(c == null) break;

            d = c.next;
            c.next = null;

            // Reverse group
            b = reverse(b);

            // Reconnect
            a.next = b;

            while(b.next != null) {
                b = b.next;
            }

            b.next = d;
            a = b;
        }

        return dummy.next;
    }
}