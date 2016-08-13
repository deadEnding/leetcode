package L051_N_Queens;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 9:09 AM 8/11/16
 * @version: 1.0
 * @description: Leetcode 51. N-Queens
 */


public class Solution {
    List<List<String>> result = new LinkedList<>();

    private void dfs(char[][] board, boolean[] col, boolean[] ld, boolean[] rd, int i) {
        final int n = board.length;
        if (i == n) {
            List<String> bd = new ArrayList<>(n);
            for (char[] chars : board)
                bd.add(new String(chars));
            result.add(bd);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!col[j] && !ld[i + j] && !rd[j - i + n - 1]) {
                board[i][j] = 'Q';
                col[j] = ld[i + j] = rd[j - i + n - 1] = true;
                dfs(board, col, ld, rd, i + 1);
                col[j] = ld[i + j] = rd[j - i + n - 1] = false;
                board[i][j] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        dfs(board, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], 0);
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> result = new Solution().solveNQueens(2);
        for (List<String> b : result) {
            for (String s : b)
                System.out.println(s);
            System.out.println();
        }
    }
}
