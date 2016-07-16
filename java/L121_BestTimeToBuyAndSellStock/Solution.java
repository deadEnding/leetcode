package L121_BestTimeToBuyAndSellStock;

/**
 * @author: deadend
 * @date: 10:47 PM 7/14/16
 * @version: 1.0
 * @description: Leetcode 121. Best Time to Buy and Sell Stock
 */


public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxDelta = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; ++i) {
            min = Math.min(min, prices[i]);
            maxDelta = Math.max(maxDelta, prices[i] - min);
        }
        return maxDelta < 0 ? 0 : maxDelta;
    }


    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
    }
}
