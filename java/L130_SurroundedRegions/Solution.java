package L130_SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: deadend
 * @date: 8:42 PM 7/16/16
 * @version: 1.0
 * @description: Leetcode 130. Surrounded Regions
 */


public class Solution {

    class Point {
        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        int row = board.length;
        int col = board[0].length;
        Queue<Point> queue = new LinkedList<>();

        // 将边界处的字符'O'放入队列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 || i == row - 1 || j == 0 || j == col - 1) && board[i][j] == 'O')
                    queue.offer(new Point(i, j));
            }
        }

        // 广度优先遍历
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            board[x][y] = 'P';

            if (x > 0 && board[x - 1][y] == 'O')
                queue.offer(new Point(x - 1, y));
            if (x < row - 1 && board[x + 1][y] == 'O')
                queue.offer(new Point(x + 1, y));
            if (y > 0 && board[x][y - 1] == 'O')
                queue.offer(new Point(x, y - 1));
            if (y < col - 1 && board[x][y + 1] == 'O')
                queue.offer(new Point(x, y + 1));
        }

        // 修改字符
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = board[i][j] == 'P' ? 'O' : 'X';
            }
        }
    }

    private void print(char[][] board) {
        for (char[] r : board) {
            for (char c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};

        Solution solution = new Solution();
        solution.print(board);
        solution.solve(board);
        solution.print(board);
    }
}
