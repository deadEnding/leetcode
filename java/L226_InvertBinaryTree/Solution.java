package L226_InvertBinaryTree;

/**
 * @author: deadend
 * @date: 12:57 PM 7/24/16
 * @version: 1.0
 * @description: Leetcode 226. Invert Binary Tree
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;
        return root;
    }
}
