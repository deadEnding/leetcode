package L042_TrappingRainWater;

/**
 * @author: deadend
 * @date: 1:08 PM 8/10/16
 * @version: 1.0
 * @description: Leetcode 42. Trapping Rain Water
 */


public class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int level = 0;
        int result = 0;

        while (l < r) {
            int lower = height[height[l] < height[r] ? l++ : r--];
            level = Math.max(level, lower);
            result += level - lower;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new OtherSolution().trap(height));
    }
}


class OtherSolution {
    public int trap(int[] height) {
        final int N = height.length;
        int[] lmax = new int[N];
        int[] rmax = new int[N];

        for (int i = 0; i < N; i++) {
            lmax[i] = Math.max(i > 0 ? lmax[i - 1] : 0, height[i]);
            int j = N - 1 - i;
            rmax[j] = Math.max(j < N - 1 ? rmax[j + 1] : 0, height[j]);
        }

        int result = 0;
        for (int i = 0; i < N; i++)
            result += Math.min(lmax[i], rmax[i]) - height[i];

        return result;
    }
}
