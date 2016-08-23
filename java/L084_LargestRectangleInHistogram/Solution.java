package L084_LargestRectangleInHistogram;

/**
 * @author: deadend
 * @date: 4:43 PM 8/15/16
 * @version: 1.0
 * @description: Leetcode 84. Largest Rectangle in Histogram
 */


public class Solution {

    private int getMax(int[] heights, int s, int e) {
        if (s == e)
            return 0;

        if (s + 1 == e)
            return heights[s];

        int min = s;
        boolean sorted = true;
        for (int i = s; i < e; i++) {
            if (i > s && heights[i] < heights[i - 1])
                sorted = false;
            min = heights[i] < heights[min] ? i : min;
        }

        if (sorted) {
            int max = 0;
            for (int i = s; i < e; i++)
                max = Math.max(max, heights[i] * (e - i));
            return max;
        }

        int left = getMax(heights, s, min);
        int right = getMax(heights, min + 1, e);
        return Math.max(Math.max(left, right), heights[min] * (e - s));
    }

    public int largestRectangleArea(int[] heights) {
        return getMax(heights, 0, heights.length);
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(new Solution().largestRectangleArea(heights));
    }
}

/* 超时 O(n^2) */
class WrongSolution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int l = i;
            while (l - 1 >=0 && heights[l - 1] >= heights[i])
                l--;

            int r = i + 1;
            while (r < heights.length && heights[r] >= heights[i])
                r++;

            max = Math.max(max, heights[i] * (r - l));
        }
        return max;
    }
}
