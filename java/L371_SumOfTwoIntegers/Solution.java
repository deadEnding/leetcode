package L371_SumOfTwoIntegers;

/**
 * @author: deadend
 * @date: 9:41 AM 8/2/16
 * @version: 1.0
 * @description: Leetcode 371. Sum of Two Integers
 */


public class Solution {
    public int getSum(int a, int b) {
        int result = a ^ b;
        int carry = (a & b) << 1;
        return carry == 0 ? result : getSum(result, carry);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getSum(-3, 5));
    }
}
