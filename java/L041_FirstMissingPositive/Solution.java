package L041_FirstMissingPositive;

/**
 * @author: deadend
 * @date: 8:24 PM 8/9/16
 * @version: 1.0
 * @description: Leetcode 41. First Missing Positive
 */


public class Solution {

    private void swap(int[] nums, int i, int j) {
        nums[i] += nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i])
                swap(nums, i, nums[i] - 1);
        }

        for (int i = 0; i < nums.length; i++)
            if (nums[i] - 1 != i)
                return i + 1;

        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(new Solution().firstMissingPositive(nums));
    }
}
