package L173_BinarySearchTreeIterator;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 3:42 PM 7/20/16
 * @version: 1.0
 * @description: Leetcode 173. Binary Search Tree Iterator
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}


/* 中断的中序遍历 */
public class BSTIterator {

    LinkedList<TreeNode> stack = new LinkedList<>();
    TreeNode p = null;

    public BSTIterator(TreeNode root) {
        p = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return p != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        int val = -1;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                val = p.val;
                p = p.right;
                break;
            }
        }
        return val;
    }
}