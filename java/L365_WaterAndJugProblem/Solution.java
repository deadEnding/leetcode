package L365_WaterAndJugProblem;

/**
 * @author: deadend
 * @date: 4:17 PM 8/1/16
 * @version: 1.0
 * @description: Leetcode 365. Water and Jug Problem
 */


public class Solution {
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0)
            return true;
        return x + y < z ? false : z % gcd(x, y) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canMeasureWater(0, 0, 0));
    }
}
