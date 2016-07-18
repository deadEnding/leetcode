package L144_BinaryTreePreorderTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 3:19 PM 7/18/16
 * @version: 1.0
 * @description: Leetcode 144. Binary Tree Preorder Traversal
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    private List<Integer> result = new LinkedList<>();

    private void preorder(TreeNode root) {
        if (root != null) {
            result.add(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return result;
    }
}

class IterSolution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null)
            return result;

        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode p = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            p = stack.pop();
            result.add(p.val);
            if (p.right != null)
                stack.push(p.right);
            if (p.left != null)
                stack.push(p.left);
        }

        return result;
    }
}

class IterSolution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null)
            return result;

        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                result.add(p.val);
                p = p.left;
            }
            p = stack.pop().right;
        }
        return result;
    }
}
