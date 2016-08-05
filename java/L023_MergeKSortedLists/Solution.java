package L023_MergeKSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: deadend
 * @date: 10:01 PM 8/5/16
 * @version: 1.0
 * @description: Leetcode 23. Merge k Sorted Lists
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        ListNode dummy = new ListNode(-1);
        Queue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for (int i = 0; i < lists.length; i++)
            if (lists[i] != null)
                queue.add(lists[i]);

        ListNode p = dummy;
        while (!queue.isEmpty()) {
            ListNode tmp = queue.poll();
            if (tmp != null) {
                if (tmp.next != null)
                    queue.add(tmp.next);
                p.next = tmp;
                p = p.next;
            }
        }
        p.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        l1.next = n1;

        ListNode l2 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        l2.next = n2;

        ListNode[] lists = new ListNode[2];
        lists[0] = l1;
        lists[1] = l2;

        ListNode head = new OtherSolution().mergeKLists(lists);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}


class OtherSolution {
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while (left != null || right != null) {
            int l = left != null ? left.val : Integer.MAX_VALUE;
            int r = right != null ? right.val : Integer.MAX_VALUE;
            p.next = l < r ? left : right;
            p = p.next;
            ListNode nouse = l < r ? (left = left.next) : (right = right.next);
        }
        p.next = null;
        return dummy.next;
    }

    private ListNode mergeSort(ListNode lists[], int l, int r) {
        if (l == r)
            return lists[l];

        int m = (l + r) / 2;
        ListNode left = mergeSort(lists, l, m);
        ListNode right = mergeSort(lists, m + 1, r);
        return merge(left, right);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        return mergeSort(lists, 0, lists.length - 1);
    }
}

