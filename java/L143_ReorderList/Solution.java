package L143_ReorderList;

import java.util.List;

/**
 * @author: deadend
 * @date: 2:28 PM 7/18/16
 * @version: 1.0
 * @description: Leetcode 143. Reorder List
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    private ListNode reverse(ListNode head) {
        if (head == null)
            return null;

        ListNode last = head;
        ListNode curr = head.next;

        while (curr != null) {
            last.next = curr.next;
            curr.next = head;
            head = curr;
            curr = last.next;
        }

        return head;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode oneStep = head;
        ListNode twoStep = head;

        while (twoStep != null && twoStep.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        ListNode head2 = oneStep.next;
        oneStep.next = null;
        head2 = reverse(head2);

        while (head2 != null) {
            ListNode tmp = head2.next;
            head2.next = head.next;
            head.next = head2;
            head = head2.next;
            head2 = tmp;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 2; i <= 4; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        tmp = null;

        tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();

        new Solution().reorderList(head);

        tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
