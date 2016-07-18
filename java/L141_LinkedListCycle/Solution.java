package L141_LinkedListCycle;

/**
 * @author: deadend
 * @date: 10:20 AM 7/18/16
 * @version: 1.0
 * @description: Leetcode 141. Linked List Cycle
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

    public boolean hasCycle(ListNode head) {
        ListNode oneStep = head;
        ListNode twoStep = head;

        while (twoStep != null && twoStep.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if (oneStep == twoStep)
                return true;
        }
        return false;
    }
}
