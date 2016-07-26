package L221_MaximalSquare;

/**
 * @author: deadend
 * @date: 3:16 PM 7/23/16
 * @version: 1.0
 * @description: Leetcode 221. Maximal Square
 */


public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        final int m = matrix.length;
        final int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int[][] f = new int[m+1][n+1];  // f[i][j]是右下角为matrix[i-1][j-1]的最大正方形的边长

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    f[i+1][j+1] = Math.min(f[i][j], Math.min(f[i+1][j], f[i][j+1])) + 1;
                    max = Math.max(max, f[i+1][j+1]);
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
        System.out.println(new Solution().maximalSquare(matrix));
    }
}
