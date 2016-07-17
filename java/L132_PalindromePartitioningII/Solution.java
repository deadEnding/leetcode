package L132_PalindromePartitioningII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 10:35 AM 7/17/16
 * @version: 1.0
 * @description:
 */

/* 动态规划，时间复杂度O(n^2) */
public class Solution {

    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPali = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                isPali[i][j] = (s.charAt(i) == s.charAt(j) && (j - i <= 1 || isPali[i+1][j-1]));
            }
        }

        int[] subMinCuts = new int[n];
        Arrays.fill(subMinCuts, Integer.MAX_VALUE);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (isPali[i][j]) {
                    if (j + 1 < n) {
                        subMinCuts[i] = Math.min(subMinCuts[i], subMinCuts[j+1] + 1);
                    } else {  // j + 1 == n
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

