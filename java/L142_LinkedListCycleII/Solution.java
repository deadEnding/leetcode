package L142_LinkedListCycleII;

import java.util.List;

/**
 * @author: deadend
 * @date: 10:46 AM 7/18/16
 * @version: 1.0
 * @description: Leetcode 142. Linked List Cycle II
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

    public ListNode detectCycle(ListNode head) {
        ListNode oneStep = head;
        ListNode twoStep = head;

        while (twoStep != null && twoStep.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
            if (oneStep == twoStep) {
                while (head != oneStep) {
                    head = head.next;
                    oneStep = oneStep.next;
                }
                return oneStep;
            }
        }
        return null;
    }
}
