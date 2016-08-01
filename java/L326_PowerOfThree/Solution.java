package L326_PowerOfThree;

/**
 * @author: deadend
 * @date: 10:44 PM 7/30/16
 * @version: 1.0
 * @description: Leetcode 326. Power of Three
 */

public class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 ? 1162261467 % n == 0: false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfThree(1));
    }
}


class OtherSolution {
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0)
            n /= 3;
        return n == 1;
    }
}

