package L222_CountCompleteTreeNodes;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 4:04 PM 7/23/16
 * @version: 1.0
 * @description: Leetcode 222. Count Complete Tree Nodes
 * http://blog.csdn.net/xudli/article/details/46385011
 * http://blog.csdn.net/booirror/article/details/47460605
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    private int height(TreeNode root, boolean toLeft) {
        int height = 0;
        while (root != null) {
            height++;
            root = toLeft ? root.left : root.right;
        }
        return height;
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int lh = height(root.left, true);
        int rh = height(root.right, false);

        if (lh == rh)
            return (1 << (lh + 1)) - 1;
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        System.out.println(new OtherSolution().countNodes(root));
    }
}


class OtherSolution {
    private int height(TreeNode root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        if (lh == rh)
            return (1 << lh) + countNodes(root.right);
        return countNodes(root.left) + (1 << rh);
    }
}

