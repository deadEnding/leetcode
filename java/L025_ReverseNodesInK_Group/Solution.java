package L025_ReverseNodesInK_Group;

/**
 * @author: deadend
 * @date: 4:23 PM 8/6/16
 * @version: 1.0
 * @description: Leetcode 25. Reverse Nodes in k-Group
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode last = head;
        ListNode prevLast = dummy;

        int i;
        for (i = 1; last != null && last.next != null;) {
            ListNode tmp = last.next;
            last.next = last.next.next;
            tmp.next = prevLast.next;
            prevLast.next = tmp;

            if (++i % k == 0) {
                prevLast = last;
                last = last.next;
                i += last != null ? 1 : 0;
            }
        }
        if (i % k != 0)
            prevLast.next = reverseKGroup(prevLast.next, i % k);

        return dummy.next;
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

        p = new OtherSolution().reverseKGroup(dummy.next, 3);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}


class OtherSolution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        while (curr != null && count != k) {
            count++;
            curr = curr.next;
        }

        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count-- > 0) {
                ListNode tmp = head.next;
                head.next = curr;
                curr = head;
                head = tmp;
            }
            head = curr;
        }
        return head;
    }
}
