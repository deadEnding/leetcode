package L236_LowestCommonAncestorOfABinaryTree;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 7:41 PM 7/25/16
 * @version: 1.0
 * @description: Leetcode 236. Lowest Common Ancestor of a Binary Tree
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        else
            return right;
    }
}


class IterSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;

        LinkedList<TreeNode> ppath = new LinkedList<>();
        LinkedList<TreeNode> qpath = new LinkedList<>();
        ppath.push(root);
        qpath.push(root);

        getPath(root, p, ppath);
        getPath(root, q, qpath);

        TreeNode lca = null;
        for (int i = 0; i < ppath.size() && i < qpath.size(); i++) {
            if (ppath.get(i) == qpath.get(i))
                lca = ppath.get(i);
            else
                break;
        }
        return lca;
    }

    private boolean getPath(TreeNode root, TreeNode n, LinkedList<TreeNode> path) {
        if (root == n)
            return true;

        if (root.left != null) {
            path.add(root.left);
            if (getPath(root.left, n, path))
                return true;
            path.removeLast();
        }

        if (root.right != null) {
            path.add(root.right);
            if (getPath(root.right, n, path))
                return true;
            path.removeLast();
        }
        return false;
    }
}
