package L238_ProductOfArrayExceptSelf;

/**
 * @author: deadend
 * @date: 9:31 PM 7/25/16
 * @version: 1.0
 * @description: Leetcode 238. Product of Array Except Self
 */


public class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        int[] output = new int[n];

        output[0] = 1;
        for (int i = 1; i < n; i++)
            output[i] = output[i-1] * nums[i-1];

        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            right *= nums[i+1];
            output[i] *= right;
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0};
        int[] result = new Solution().productExceptSelf(nums);
        for (int n : result)
            System.out.print(n + "  ");
        System.out.println();
    }
}


class OtherSolution {
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        int[] output = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = i == 0 ? 1 : left[i - 1] * nums[i - 1];
            int j = n - 1 - i;
            right[j] = j == n - 1 ? 1 : right[j + 1] * nums[j + 1];
        }

        for (int i = 0; i < n; i++)
            output[i] = left[i] * right[i];

        return output;
    }
}
