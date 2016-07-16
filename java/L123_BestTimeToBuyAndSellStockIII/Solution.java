package L123_BestTimeToBuyAndSellStockIII;

/**
 * @author: deadend
 * @date: 10:39 AM 7/16/16
 * @version: 1.0
 * @description: Leetcode 123. Best Time to Buy and Sell Stock III
 */


public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0)
            return 0;

        int[] f = new int[len];
        int[] g = new int[len];

        for (int i = 1, min = prices[0]; i < len; ++i) {
            min = Math.min(min, prices[i]);
            f[i] = Math.max(f[i-1], prices[i] - min);
        }

        for (int i = len - 2, max = prices[len - 1]; i >= 0; --i) {
            max = Math.max(max, prices[i]);
            g[i] = Math.max(g[i+1], max - prices[i]);
        }

        int result = 0;
        for (int i = 0; i < len; ++i) {
            result = Math.max(result, f[i] + (i < len - 1 ? g[i+1] : 0));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
    }
}
