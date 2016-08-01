package L337_HouseRobberIII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: deadend
 * @date: 7:24 PM 7/31/16
 * @version: 1.0
 * @description: Leetcode 337. House Robber III
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {

    private int[] dfs(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};

        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int[] max = new int[2];
        max[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        max[1] = l[0] + r[0] + root.val;
        return max;
    }

    public int rob(TreeNode root) {
        int[] max = dfs(root);
        return Math.max(max[0], max[1]);
    }
}
