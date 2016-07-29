package L263_UglyNumber;

/**
 * @author: deadend
 * @date: 4:15 PM 7/26/16
 * @version: 1.0
 * @description: Leetcode 263. Ugly Number
 */


public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0)
            return false;

        int[] primes = {2, 3, 5};
        for (int p : primes) {
            while (num % p == 0)
                num = num / p;
        }

        return num == 1 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isUgly(1));
    }
}
