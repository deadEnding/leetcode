package L203_RemoveLinkedListElements;

/**
 * @author: deadend
 * @date: 5:03 PM 7/21/16
 * @version: 1.0
 * @description: Leetcode 203. Remove Linked List Elements
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;

        while (p.next != null) {
            if (p.next.val ==  val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
