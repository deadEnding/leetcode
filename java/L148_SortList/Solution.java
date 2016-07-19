package L148_SortList;

import java.util.List;

/**
 * @author: deadend
 * @date: 2:42 PM 7/19/16
 * @version: 1.0
 * @description: Leetcode 148. Sort List
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

/* 单向链表适合归并排序，双向链表适合快速排序 */
public class Solution {
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        for (ListNode p = dummy; l1 != null || l2 != null; p = p.next) {
            int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (val1 <= val2) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
        }
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode oneStep = head;
        ListNode twoStep = head;
        while (twoStep.next != null && twoStep.next.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        ListNode head2 = oneStep.next;
        oneStep.next = null;
        return merge(sortList(head), sortList(head2));
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1};
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

        p = new Solution().sortList(head);

        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();

    }
}
