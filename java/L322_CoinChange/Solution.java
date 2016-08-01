package L322_CoinChange;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 2:34 PM 7/30/16
 * @version: 1.0
 * @description: Leetcode 322. Coin Change
 */

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] counter = new int[amount + 1];
        counter[0] = 0;
        for (int i = 1; i <= amount; i++) {
            counter[i] = amount + 1;
            for (int c : coins) {
                if (c <= i) {
                    counter[i] = Math.min(counter[i], counter[i - c] + 1);
                }
            }
        }
        return counter[amount] > amount ? -1 : counter[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(new Solution().coinChange(coins, 3));
    }
}


/* 包含大量重复计算，超时 */
class OtherSolution {

    private int change(int ix, int[] coins, int amount) {
        System.out.println(ix + " " + amount);
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;

        int min = Integer.MAX_VALUE;
        for (int i = ix; i >= 0; i--) {
            int count = change(ix, coins, amount - coins[i]);
            if (count != -1)
                min = Math.min(min, count);
        }
        return min == Integer.MAX_VALUE ? -1 : min + 1;
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return change(coins.length - 1, coins, amount);
    }
}
