package L129_SumRootToLeafNumbers;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 8:21 PM 7/16/16
 * @version: 1.0
 * @description: Leetcode 129. Sum Root to Leaf Numbers
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

    private int sum = 0;

    private void preOrder(TreeNode root, int subsum) {
        if (root != null) {
            subsum = subsum * 10 + root.val;
            if (root.left == null && root.right == null) {
                sum += subsum;
            } else {
                preOrder(root.left, subsum);
                preOrder(root.right, subsum);
            }
        }
    }

    public int sumNumbers(TreeNode root) {
        preOrder(root, 0);
        return sum;
    }
}
