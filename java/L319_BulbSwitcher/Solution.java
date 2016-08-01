package L319_BulbSwitcher;

/**
 * @author: deadend
 * @date: 11:59 AM 7/30/16
 * @version: 1.0
 * @description: Leetcode 319. Bulb Switcher
 */


public class Solution {
    public int bulbSwitch(int n) {
        int on = 0;
        for (int i = 1; i * i <= n; i++)
            on++;
        return on;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().bulbSwitch(25));
    }
}
