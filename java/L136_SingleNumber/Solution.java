package L136_SingleNumber;

/**
 * @author: deadend
 * @date: 10:47 PM 7/17/16
 * @version: 1.0
 * @description: Leetcode 136. Single Number
 */


public class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int i : nums) {
            x ^= i;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums = {1,-2,3,4,1,-2,3};
        System.out.println(new Solution().singleNumber(nums));
    }
}
