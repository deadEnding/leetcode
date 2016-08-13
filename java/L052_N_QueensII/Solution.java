package L052_N_QueensII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 10:18 AM 8/11/16
 * @version: 1.0
 * @description: Leetcode 52. N-Queens II
 */


public class Solution {
    private int dfs(boolean[] col, boolean[] ld, boolean[] rd, int i) {
        final int n = col.length;
        if (i == n) {
            return 1;
        }

        int total = 0;
        for (int j = 0; j < n; j++) {
            if (!col[j] && !ld[i + j] && !rd[j - i + n - 1]) {
                col[j] = ld[i + j] = rd[j - i + n - 1] = true;
                total += dfs(col, ld, rd, i + 1);
                col[j] = ld[i + j] = rd[j - i + n - 1] = false;
            }
        }
        return total;
    }

    public int totalNQueens(int n) {
        return dfs(new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], 0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().totalNQueens(1));
    }
}
