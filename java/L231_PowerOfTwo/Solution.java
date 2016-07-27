package L231_PowerOfTwo;

/**
 * @author: deadend
 * @date: 9:24 PM 7/24/16
 * @version: 1.0
 * @description: Leetcode 231. Power of Two
 */


/* 考虑溢出 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        long i = 1;
        while (i < n) {
            i <<= 1;
        }
        return i == n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(1073741825));
    }
}