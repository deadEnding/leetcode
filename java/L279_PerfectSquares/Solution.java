package L279_PerfectSquares;

/**
 * @author: deadend
 * @date: 9:27 AM 7/27/16
 * @version: 1.0
 * @description: Leetcode 279. Perfect Squares
 */

/* 离散背包问题 */

/* 自底向上 */
public class Solution {
    public int numSquares(int n) {
        int[] f = new int[n+1];
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = i;  // 至多i个1即可
            for (int j = 1; j * j <= i; j++) {
                f[i] = Math.min(f[i - j * j] + 1, f[i]);
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(new OtherSolution().numSquares(11));
    }
}

/* 自顶向下 */
class OtherSolution {

    private int dp(int n, int[] f) {
        if (n == 0)
            return 0;

        if (f[n] == 0) {
            f[n] = n;
            for (int i = 1; i * i <= n; i++)
                f[n] = Math.min(f[n], dp(n - i * i, f) + 1);
        }
        return f[n];
    }

    public int numSquares(int n) {
        int[] f = new int[n + 1];
        return dp(n, f);
    }
}

