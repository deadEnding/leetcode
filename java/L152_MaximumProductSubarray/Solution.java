package L152_MaximumProductSubarray;

/**
 * @author: deadend
 * @date: 4:53 PM 7/19/16
 * @version: 1.0
 * @description: Leetcode 152.MaximumProductSubarray
 */


public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        final int n = nums.length;
        int subMin = nums[0];
        int subMax = nums[0];
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            int tmpMax = subMax * nums[i];
            int tmpMin = subMin * nums[i];
            subMax = Math.max(Math.max(tmpMax, tmpMin), nums[i]);
            subMin = Math.min(Math.min(tmpMax, tmpMin), nums[i]);
            result = Math.max(result, subMax);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2};
        System.out.println(new Solution().maxProduct(nums));
    }
}
