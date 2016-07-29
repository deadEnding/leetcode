package L260_SingleNumberIII;

/**
 * @author: deadend
 * @date: 2:30 PM 7/26/16
 * @version: 1.0
 * @description: Leetcode 260. Single Number III
 * @refer: http://www.jianshu.com/p/683ffad6396b
 */


public class Solution {
    public int[] singleNumber(int[] nums) {
        // 求两个数的异或值
        int xor = 0;
        for (int n : nums)
            xor ^= n;

        // 求从低位起最先出现的1
        int mask = xor & (~(xor - 1));

        // 分组、异或
        int[] result = {0, 0};
        for (int n : nums) {
            if ((n & mask) == 0)
                result[0] ^= n;
            else
                result[1] ^= n;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = new Solution().singleNumber(new int[] {1,2,1,2,3,5});
        System.out.println(result[0] + "   " + result[1]);
    }
}
