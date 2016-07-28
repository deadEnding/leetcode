package L237_DeleteNodeInALinkedList;

/**
 * @author: deadend
 * @date: 9:19 PM 7/25/16
 * @version: 1.0
 * @description: Leetcode 237. Delete Node in a Linked List
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
