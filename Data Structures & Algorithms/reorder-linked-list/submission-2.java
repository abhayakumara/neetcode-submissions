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
        if(head == null || head.next == null) return;

        ListNode slow = head, fast = head, prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = prev.next;
        prev.next = null;

        newHead = rev(newHead);

        ListNode ans = new ListNode(-1);

        while(head != null) {
            ans.next = head;
            ans = ans.next;
            head = head.next;

            ans.next = newHead;
            ans = ans.next;
            newHead = newHead.next;
        }
        head = ans.next;
    }

    private ListNode rev(ListNode head) {
        ListNode prev = null, curr = head, next = head.next;

        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) {
                next = next.next;
            }
        }
        return prev;
    }
}
