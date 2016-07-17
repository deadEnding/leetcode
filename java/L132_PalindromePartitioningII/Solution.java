package L132_PalindromePartitioningII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 10:35 AM 7/17/16
 * @version: 1.0
 * @description: Leetcode 132. Palindrome Partitioning II
 */

/* 动态规划，时间复杂度O(n^2) */
public class Solution {

    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPali = new boolean[n][n];
        int[] subMinCuts = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            subMinCuts[i] = n - 1 - i;
            for (int j = i; j < n; j++) {
                isPali[i][j] = (s.charAt(i) == s.charAt(j) && (j - i <= 1 || isPali[i+1][j-1]));
                if (isPali[i][j]) {
                    if (j + 1 < n) {
                        subMinCuts[i] = Math.min(subMinCuts[i], subMinCuts[j+1] + 1);
                    } else {  // j + 1 == n，即s[i:n-1]是回文串，不需要划分
                        subMinCuts[i] = 0;
                    }
                }
            }
        }
        return subMinCuts[0];
    }

    public static void main(String[] args) {
        String str = "aabbcbb";
        Solution solution = new Solution();
        System.out.println(solution.minCut(str));
    }
}

