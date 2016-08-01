package L334_IncreasingTripletSubsequence;

/**
 * @author: deadend
 * @date: 7:18 PM 7/31/16
 * @version: 1.0
 * @description: Leetcode 334. Increasing Triplet Subsequence
 */


public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= small) {
                small = n;
            } else if (n <= middle) {
                middle = n;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(new Solution().increasingTriplet(nums));
    }
}
