package L234_PalindromeLinkedList;

/**
 * @author: deadend
 * @date: 9:32 PM 7/24/16
 * @version: 1.0
 * @description: Leetcode 234. Palindrome Linked List
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode oneStep = head;
        ListNode twoStep = head;
        while (twoStep.next != null && twoStep.next.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = oneStep.next;
        oneStep.next = null;

        oneStep = dummy.next;
        while (oneStep.next != null) {
            ListNode tmp = oneStep.next;
            oneStep.next = oneStep.next.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }

        ListNode head2 = dummy.next;
        while (head2 != null) {
            if (head.val != head2.val)
                return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        for (int n : nums) {
            p.next = new ListNode(n);
            p = p.next;
        }
        p.next = null;

        p = dummy.next;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();

        System.out.println(new Solution().isPalindrome(dummy.next));
    }
}
