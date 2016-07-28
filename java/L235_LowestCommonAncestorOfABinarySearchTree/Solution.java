package L235_LowestCommonAncestorOfABinarySearchTree;

/**
 * @author: deadend
 * @date: 7:36 PM 7/25/16
 * @version: 1.0
 * @description: Leetcode 235. Lowest Common Ancestor of a Binary Search Tree
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((p.val - root.val) * (q.val - root.val) <= 0)
            return root;

        if (p.val - root.val < 0)
            return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }
}
