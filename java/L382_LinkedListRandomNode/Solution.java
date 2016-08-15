package L382_LinkedListRandomNode;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author: deadend
 * @date: 8:55 AM 8/10/16
 * @version: 1.0
 * @description: Leetcode 382. Linked List Random Node
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {

    ArrayList<Integer> arrayList;
    Random rand;

    /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        rand = new Random();
        arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        return arrayList.get(rand.nextInt(arrayList.size()));
    }

    public static void main(String[] args) {

    }
}
