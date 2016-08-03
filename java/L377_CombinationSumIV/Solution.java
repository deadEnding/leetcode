package L377_CombinationSumIV;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: deadend
 * @date: 9:57 PM 8/2/16
 * @version: 1.0
 * @description: Leetcode 377. Combination Sum IV
 */


public class Solution {
    private int dfs(int[] nums, int n, HashMap<Integer, Integer> map) {
        if (n <= 0)
            return n < 0 ? 0 : 1;

        if (!map.containsKey(n)) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                count += dfs(nums, n - nums[i], map);
            }
            map.put(n, count);
        }

        return map.get(n);
    }

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        return dfs(nums, target, new HashMap<Integer, Integer>());
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().combinationSum4(nums, 32));
    }
}
