package L328_OddEvenLinkedList;

/**
 * @author: deadend
 * @date: 11:30 AM 7/31/16
 * @version: 1.0
 * @description: Leetcode 328. Odd Even Linked List
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;

        ListNode tmpHead = head.next;
        ListNode p = head;
        ListNode q = tmpHead;
        while (q != null && q.next != null) {
            p.next = q.next;
            p = p.next;
            q.next = p.next;
            q = q.next;
        }
        p.next = tmpHead;
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        for (int n : nums) {
            p.next = new ListNode(n);
            p = p.next;
        }
        p.next = null;

        p = new Solution().oddEvenList(dummy.next);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}
