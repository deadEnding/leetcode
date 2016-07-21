package L160_IntersectionOfTwoLinkedLists;

/**
 * @author: deadend
 * @date: 10:11 PM 7/19/16
 * @version: 1.0
 * @description: Leetcode 160. Intersection of Two Linked Lists
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    private int length(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);

        ListNode longer = lenA < lenB ? headB : headA;
        ListNode shorter = lenA < lenB ? headA : headB;

        int delta = Math.abs(lenA - lenB);
        while (delta-- > 0) {
            longer = longer.next;
        }

        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }
        return longer;
    }
}
