package L172_FactorialTrailingZeroes;

/**
 * @author: deadend
 * @date: 3:01 PM 7/20/16
 * @version: 1.0
 * @description: Leetcode 172. Factorial Trailing Zeroes
 */


public class Solution {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n != 0) {
            n /= 5;
            cnt += n;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(1000));
    }
}
