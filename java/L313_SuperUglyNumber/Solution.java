package L313_SuperUglyNumber;

/**
 * @author: deadend
 * @date: 10:59 AM 7/30/16
 * @version: 1.0
 * @description: Leetcode 313. Super Ugly Number
 */


public class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] uglyNums = new int[n];
        int[] f = new int[primes.length];

        uglyNums[0] = 1;
        for (int i = 1; i < n; i++) {
            uglyNums[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                uglyNums[i] = Math.min(uglyNums[i], primes[j] * uglyNums[f[j]]);
            }

            for (int j = 0; j < primes.length; j++)
                if (uglyNums[i] == primes[j] * uglyNums[f[j]])
                    f[j]++;
        }

        return uglyNums[n-1];
    }

    public static void main(String[] args) {
        int[] primes = {2, 7, 13, 19};
        System.out.println(new Solution().nthSuperUglyNumber(12, primes));
    }
}
