package L137_SingleNumberII;

/**
 * @author: deadend
 * @date: 10:58 PM 7/17/16
 * @version: 1.0
 * @description: 137. Single Number II
 */

/* 时间复杂度O(n)，空间复杂度O(1) */
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        int bits = 4 * 8;
        int[] bitCounter = new int[bits];

        for (int i = 0; i < bits; i++) {
            for (int n : nums) {
                if ((n & (1 << i)) != 0) {
                    bitCounter[i]++;
                }
            }
            if (bitCounter[i] % 3 != 0)
                result += (1 << i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,1};
        System.out.println(new Solution().singleNumber(nums));
    }
}
