package L343_IntegerBreak;

/**
 * @author: deadend
 * @date: 9:56 AM 8/1/16
 * @version: 1.0
 * @description: Leetcode 343. Integer Break
 */

/* 动态规划, O(n) */
public class Solution {
    public int integerBreak(int n) {
        int[] f = new int[n + 1];
        f[1] = 0;
        f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = 1;
            for (int j = 1; 2 * j <= i; j++) {
                f[i] = Math.max(f[i], Math.max(j, f[j]) * Math.max(i - j, f[i - j]));
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(new OtherSolution().integerBreak(8));
    }
}


/* 均值不等式, O(1) */
class OtherSolution {
    public int integerBreak(int n) {
        int result = 0;
        if (n == 2) {
            result = 1;
        } else if (n == 3) {
            result = 2;
        } else {
            switch (n % 3) {
                case 0:
                    result = (int)Math.pow(3, n/3);
                    break;
                case 1:
                    result = (int)Math.pow(3, n/3) * 4;
                    break;
                case 2:
                    result = (int)Math.pow(3, n/3) * 2;
                    break;
            }
        }
        return result;
    }
}
