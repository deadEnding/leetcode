package L375_GuessNumberHigherOrLowerII;

/**
 * @author: deadend
 * @date: 2:21 PM 8/2/16
 * @version: 1.0
 * @description: Leetcode 375. Guess Number Higher or Lower II
 */


public class Solution {

    private int payForRange(int[][] dp, int start, int end) {
        if (start >= end)
            return 0;

        if (dp[start][end] != 0)
            return dp[start][end];

        dp[start][end] = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int pay = i + Math.max(payForRange(dp, start, i - 1), payForRange(dp, i + 1, end));
            dp[start][end] = Math.min(dp[start][end], pay);
        }
        return dp[start][end];
    }

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return payForRange(dp, 1, n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMoneyAmount(100));
    }
}
