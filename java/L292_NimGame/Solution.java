package L292_NimGame;

/**
 * @author: deadend
 * @date: 3:29 PM 7/27/16
 * @version: 1.0
 * @description: Leetcode 292. Nim Game
 */


public class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canWinNim(5));
    }
}
