package L055_JumpGame;

/**
 * @author: deadend
 * @date: 3:57 PM 8/10/16
 * @version: 1.0
 * @description: Leetcode 55. Jump Game
 */


public class Solution {
    public boolean canJump(int[] nums) {
        int far = 0;
        for (int i = 0; i <= Math.min(far, nums.length - 1); i++) {
            far = Math.max(far, i + nums[i]);
        }
        return far >= nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(new Solution().canJump(nums));
    }
}
