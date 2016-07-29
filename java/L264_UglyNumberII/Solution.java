package L264_UglyNumberII;


import java.util.Arrays;

/**
 * @author: deadend
 * @date: 4:47 PM 7/26/16
 * @version: 1.0
 * @description: Leetcode 264. Ugly Number II
 */


public class Solution {

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;

        uglyNums[0] = 1;
        for (int i = 1; i < n; i++) {
            uglyNums[i] = min(uglyNums[i2] * 2, uglyNums[i3] * 3, uglyNums[i5] * 5);
            if (uglyNums[i] == uglyNums[i2] * 2)
                i2++;
            if (uglyNums[i] == uglyNums[i3] * 3)
                i3++;
            if (uglyNums[i] == uglyNums[i5] * 5)
                i5++;
        }
        return uglyNums[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
    }
}
