package L209_MinimumSizeSubarraySum;

/**
 * @author: deadend
 * @date: 9:05 PM 7/22/16
 * @version: 1.0
 * @description: Leetcode 209. Minimum Size Subarray Sum
 */


public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int b = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= s) {
                while (b <= i && sum >= s)
                    sum -= nums[b++];
                min = Math.min(min, i - b + 2);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(3, new int[] {2,3,1,2,4,3}));
    }
}
