package L258_AddDigits;

/**
 * @author: deadend
 * @date: 2:15 PM 7/26/16
 * @version: 1.0
 * @description: Leetcode 258. Add Digits
 */


public class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addDigits(0));
        System.out.println(new Solution().addDigits(4));
        System.out.println(new Solution().addDigits(14));
    }
}
