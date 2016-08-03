package L376_WiggleSubsequence;

/**
 * @author: deadend
 * @date: 8:44 PM 8/2/16
 * @version: 1.0
 * @description: Leetcode 376. Wiggle Subsequence
 */


public class Solution {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        int sign = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int tmp = nums[i + 1] - nums[i];
            if ((sign == 0 && tmp != 0) || sign * tmp < 0) {
                count++;
                sign = tmp;
            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new GreedySolution().wiggleMaxLength(nums));
    }
}


class GreedySolution {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0)
            return 0;

        int f = 1, d = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                f = d + 1;
            else if (nums[i] > nums[i - 1])
                d = f + 1;
        }
        return Math.max(f, d);
    }
}
