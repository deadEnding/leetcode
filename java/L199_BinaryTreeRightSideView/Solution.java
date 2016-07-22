package L199_BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 2:11 PM 7/21/16
 * @version: 1.0
 * @description: Leetcode 199. Binary Tree Right Side View
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private void preOrder(TreeNode root, int level, List<Integer> result) {
        if (root != null) {
            if (result.size() <= level)
                result.add(root.val);
            else
                result.set(level, root.val);
            preOrder(root.left, level + 1, result);
            preOrder(root.right, level + 1, result);
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, 0, result);
        return result;
    }
}

class BFSSolution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null)
            return result;

        LinkedList<TreeNode> queue = new LinkedList<>();
        int levelCnt = 1;
        int nextLevelCnt = 0;
        queue.push(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelCnt--;
            if (node.left != null) {
                queue.offer(node.left);
                nextLevelCnt++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevelCnt++;
            }
            if (levelCnt == 0) {
                result.add(node.val);
                levelCnt = nextLevelCnt;
                nextLevelCnt = 0;
            }
        }
        return result;
    }
}
