package L223_RectangleArea;

/**
 * @author: deadend
 * @date: 10:38 AM 7/24/16
 * @version: 1.0
 * @description: Leetcode 223. Rectangle Area
 */


public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long x = (long)Math.min(C, G) - (long)Math.max(A, E);
        long y = (long)Math.min(D, H) - (long)Math.max(B, F);
        long common = x < 0 || y < 0 ? 0 : x * y;
        long result = (C - A) * (D - B) + (G - E) * (H - F) - common;
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println(new Solution().computeArea(-2, -2, 2, 2, 1, -3, 3, -1));
        System.out.println(new Solution().computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
    }
}
