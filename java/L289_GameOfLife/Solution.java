package L289_GameOfLife;

/**
 * @author: deadend
 * @date: 2:42 PM 7/27/16
 * @version: 1.0
 * @description: Leetcode 289. Game of Life
 * @refer: http://unknown66.blogspot.com/?q=289.+Game+of+Life
 */


public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        final int m = board.length;
        final int n = board[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int count = 0;
                for (int i = Math.max(0, row - 1); i < Math.min(m, row + 2); i++)
                    for (int j = Math.max(0, col - 1); j < Math.min(n, col + 2); j++)
                        count += (board[i][j] & 1);

                // count == 3 covers board[row][col] == 1 && live neighbors = 2
                // and, board[row][col] == 0 && live neighbors = 3;
                // count - board[row][col] == 3 covers board[row][col] == 1 && live neighbors = 3
                // and, board[row][col] == 0 && live neighbors = 3.
                if (count == 3 || count - board[row][col] == 3)
                    board[row][col] |= 2;
            }
        }

        for (int row = 0; row < m; row++)
            for (int col = 0; col < n; col++)
                board[row][col] >>= 1;
    }

    public static void main(String[] args) {
        int[][] board = {{0}};
        new Solution().gameOfLife(board);
    }
}
