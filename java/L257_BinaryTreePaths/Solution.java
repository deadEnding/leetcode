package L257_BinaryTreePaths;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 1:40 PM 7/26/16
 * @version: 1.0
 * @description: Leetcode 257. Binary Tree Paths
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {
    private List<String> result = new LinkedList<>();

    private void dfs(TreeNode root, LinkedList<Integer> path) {
        if (root.left == null && root.right == null) {
            StringBuffer sb = new StringBuffer();
            for (int i : path)
                sb.append(i + "->");
            sb.append(root.val);
            result.add(sb.toString());
            return;
        }

        path.addLast(root.val);

        if (root.left != null)
            dfs(root.left, path);
        if (root.right != null)
            dfs(root.right, path);

        path.removeLast();
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return result;

        dfs(root, new LinkedList<Integer>());
        return result;
    }
}
