package L357_CountNumbersWithUniqueDigits;

/**
 * @author: deadend
 * @date: 3:08 PM 8/1/16
 * @version: 1.0
 * @description: Leetcode 357. Count Numbers with Unique Digits
 */


public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int sum = 1;
        int base = 9;
        for (int i = 1; i <= n && i <= 10; i++) {
            sum += base;
            base *= (10 - i);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countNumbersWithUniqueDigits(10));
    }
}
