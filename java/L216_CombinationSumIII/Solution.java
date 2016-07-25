package L216_CombinationSumIII;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 10:52 AM 7/23/16
 * @version: 1.0
 * @description: Leetcode 216. Combination Sum III
 */


public class Solution {
    private  List<List<Integer>> result = new LinkedList<>();

    // 回溯
    private void combination(int k, int n, int ix, LinkedList<Integer> path) {
        if (k == 0 && n == 0) {
            result.add(new LinkedList<Integer>(path));
            return;
        }

        // 剪枝
        if (k == 0 || n <= 0)
            return;

        // 展开分支
        for (int i = ix; i <= 9; i++) {
            path.addLast(i);
            combination(k - 1, n - i, i + 1, path);
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        combination(k, n, 1, new LinkedList<Integer>());
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Solution().combinationSum3(3, 7);
        for (List<Integer> list : result) {
            for (Integer i : list)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
