package L213_HouseRobberII;

/**
 * @author: deadend
 * @date: 11:42 PM 7/22/16
 * @version: 1.0
 * @description: Leetcode 213. House Robber II
 */


public class Solution {

    // 返回nums[s:e-1]可偷得的最大金额
    private int rob(int[] nums, int s, int e) {
        if (e - s == 0)
            return 0;

        int prev = 0;
        int curr = nums[s];
        for (int i = s + 1; i < e; i++) {
            int tmp = curr;
            curr = Math.max(prev + nums[i], curr);
            prev = tmp;
        }

        return curr;
    }

    public int rob(int[] nums) {
        final int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];

        return Math.max(rob(nums, 0, n - 1), rob(nums, 1, n));
    }


    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new Solution().rob(nums));
    }
}
