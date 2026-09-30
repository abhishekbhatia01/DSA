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

    public ListNode reverseList(ListNode head, ListNode end) {
        ListNode prev = end;
        ListNode curr = head;

        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {
            ListNode temp = groupPrev.next;
            int count = 0;

            while (temp != null && count < k) {
                temp = temp.next;
                count++;
            }

            if (count != k) {
                break;
            }

            ListNode groupStart = groupPrev.next;
            ListNode newHead = reverseList(groupStart, temp);

            groupPrev.next = newHead;
            groupPrev = groupStart;
        }

        return dummy.next;
    }
}