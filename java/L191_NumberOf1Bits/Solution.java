package L191_NumberOf1Bits;

/**
 * @author: deadend
 * @date: 10:11 AM 7/21/16
 * @version: 1.0
 * @description: Leetcode 191. Number of 1 Bits
 */


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++)
            count += ((n >> i) & 1);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(11));
    }
}
