package L283_MoveZeroes;

/**
 * @author: deadend
 * @date: 11:42 AM 7/27/16
 * @version: 1.0
 * @description: Leetcode 283. Move Zeroes
 */


public class Solution {
    public void moveZeroes(int[] nums) {
        int ix = 0;
        for (int i  = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[ix++] = nums[i];
        }
        while (ix < nums.length)
            nums[ix++] = 0;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        new Solution().moveZeroes(nums);
        for (int n : nums)
            System.out.print(n + " ");
    }
}
