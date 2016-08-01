package L309_BestTimeToBuyAndSellStockWithCooldown;

/**
 * @author: deadend
 * @date: 7:44 PM 7/29/16
 * @version: 1.0
 * @description: Leetcode 309. Best Time to Buy and Sell Stock with Cooldown
 * @refer: http://www.cnblogs.com/jdneo/p/5228004.html
 */


/* 状态机 */
public class Solution {
    public int maxProfit(int[] prices) {
        final int n = prices.length;
        if (n == 0)
            return 0;

        int[][] f = new int[n][3]; // 第i天的3种状态，不是第i天的动作

        f[0][0] = 0;
        f[0][1] = -prices[0];
        f[0][2] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(f[i-1][0], f[i-1][2]);
            f[i][1] = Math.max(f[i-1][1], f[i-1][0] - prices[i]);
            f[i][2] = f[i-1][1] + prices[i];
        }

        return Math.max(f[n-1][0], f[n-1][2]);
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 4};
        System.out.println(new Solution().maxProfit(prices));
    }
}
