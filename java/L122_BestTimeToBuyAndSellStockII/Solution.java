package L122_BestTimeToBuyAndSellStockII;

/**
 * @author: deadend
 * @date: 9:27 AM 7/16/16
 * @version: 1.0
 * @description: Leetcode 122. Best Time to Buy and Sell Stock II.
 */


public class Solution {

    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; ++i) {
            int diff = prices[i] - prices[i-1];
            sum += (diff > 0 ? diff : 0);
        }
        return sum;
    }

    /* 累加递增区间即可 */
    public int OtherSolutionMaxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int result = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < prices[i-1]) {
                result += prices[i-1] - min;
                min = prices[i];
            }
        }
        result += prices[prices.length - 1] - min;
        return result;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
    }
}
