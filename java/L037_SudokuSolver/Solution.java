package L037_SudokuSolver;


/**
 * @author: deadend
 * @date: 4:30 PM 8/9/16
 * @version: 1.0
 * @description: Leetcode 37. Sudoku Solver
 */


public class Solution {
    final int N = 9;

    private boolean isValid(int[][] f, int i, int j, int val) {
        int b = 1 << val;
        return (f[0][i] & b) + (f[1][j] & b) + (f[2][i / 3 * 3 + j / 3] & b) == 0;
    }

    private void doUpdate(int[][] f, int i, int j, int val) {
        int b = 1 << val;
        f[0][i] |= b;
        f[1][j] |= b;
        f[2][i / 3 * 3 + j / 3] |= b;
    }

    private void undoUpdate(int[][] f, int i, int j, int val) {
        int b = 1 << val;
        f[0][i] ^= b;
        f[1][j] ^= b;
        f[2][i / 3 * 3 + j / 3] ^= b;
    }

    private boolean solve(char[][] board, int[][] f, int ix) {
        if (ix == N * N)
            return true;

        int i = ix / N;
        int j = ix % N;

        if (board[i][j] != '.')
            return solve(board, f, ix + 1);

        for (int v = 1; v <= N; v++) {
            if (isValid(f, i, j, v)) {
                doUpdate(f, i, j, v);
                board[i][j] = (char)('0' + v);
                if (solve(board, f, ix + 1))
                    return true;
                board[i][j] = '.';
                undoUpdate(f, i, j, v);
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        int[][] f = new int[3][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != '.')
                    doUpdate(f, i, j, board[i][j] - '0');
            }
        }

        solve(board, f, 0);
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'}, {'.','9','8','.','.','.','.','6','.'}, {'8','.','.','.','6','.','.','.','3'}, {'4','.','.','8','.','3','.','.','1'}, {'7','.','.','.','2','.','.','.','6'}, {'.','6','.','.','.','.','2','8','.'}, {'.','.','.','4','1','9','.','.','5'}, {'.','.','.','.','8','.','.','7','9'}};
        new Solution().solveSudoku(board);
        for (char[] row : board) {
            for (char c : row)
                System.out.print(c + " ");
            System.out.println();
        }
    }
}
