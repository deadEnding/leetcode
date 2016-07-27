package L230_KthSmallestElementInABST;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 8:11 PM 7/24/16
 * @version: 1.0
 * @description: Leetcode 230. Kth Smallest Element in a BST
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (--k == 0)
                    return p.val;
                p = p.right;
            }
        }
        return -1;
    }
}
