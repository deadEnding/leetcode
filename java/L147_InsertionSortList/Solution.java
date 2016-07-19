package L147_InsertionSortList;

import java.util.List;

/**
 * @author: deadend
 * @date: 1:39 PM 7/19/16
 * @version: 1.0
 * @description: Leetcode 147. Insertion Sort List
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}


public class Solution {
    private ListNode findInsertPosition(ListNode head, ListNode node) {
        ListNode prev = null;
        for (ListNode curr = head; curr != null && curr.val <= node.val; prev = curr, curr = curr.next)
            ;
        return prev;
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);  // 构建临时链表，将原链表插入到该链表

        for (ListNode curr = head; curr != null;) {
            ListNode pos = findInsertPosition(dummy, curr);
            ListNode tmp = curr.next;
            curr.next = pos.next;
            pos.next = curr;
            curr = tmp;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {3,1};
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;

        for (int i = 1; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        p = null;

        p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();

        p = new Solution().insertionSortList(head);

        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();

    }
}


class OtherSolution {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            ListNode t = dummy;
            while (t.next != null && t.next.val <= curr.val && t.next != curr)
                t = t.next;

            if (t.next != curr) {
                prev.next = curr.next;
                curr.next = t.next;
                t.next = curr;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }

}
