package L300_LongestIncreasingSubsequence;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 9:29 AM 7/28/16
 * @version: 1.0
 * @description: Leetcode 300. Longest Increasing Subsequence
 * @refer: http://unknown66.blogspot.com/search?q=300.Longest+Increasing+Subsequence
 */


public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return -1;

        int N = nums.length;
        if (N < 2) return N;

        int[] sorted = new int[N];
        int len = 0, i;

        for (int num : nums) {
            /*
            Binary search in sorted array within [0, len). If found,
            a positive insertion index is returned (no use in this problem
            as it does not make increasing sequence longer), otherwise,
            a negative insertion index is returned. Then the value is 'inserted'
            to the position. If the value is appended to the end, increase len,
            otherwise, we simply 'replace' the value at that position.
            */
            i = Arrays.binarySearch(sorted, 0, len, num);
            System.out.println(i);
            if (i < 0) {
                i = -i - 1;
                sorted[i] = num;
            }

            if (i == len) len++;
        }

        return len;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
    }
}


/* 动态规划 O(n^2)
 * f[i] = max(f[j] + 1)，其中 j < i && nums[j] < nums[i]
 */
class OtherSolution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        final int n = nums.length;
        int[] lis = new int[n];

        int max = 1;
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
            max = Math.max(max, lis[i]);
        }

        return max;
    }
}

