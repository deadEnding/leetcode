package L304_RangeSumQuery2d_Immutable;

import L303_RangeSumQuery_Immutable.NumArray;

/**
 * @author: deadend
 * @date: 11:23 AM 7/28/16
 * @version: 1.0
 * @description: Leetcode 304. Range Sum Query 2D - Immutable
 */

public class NumMatrix {

    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                matrix[row][col] += matrix[row][col-1];
            }
        }
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; row++) {
            sum += matrix[row][col2] - (col1 == 0 ? 0 : matrix[row][col1-1]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
}

class OtherNumMatrix {

    private int[][] sum;

    public OtherNumMatrix(int[][] matrix) {
        if (matrix.length == 0)
            return;
        sum = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum[i+1][j+1] = sum[i][j+1] + sum[i+1][j] + matrix[i][j] - sum[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] + sum[row1][col1] - sum[row1][col2+1] -  sum[row2+1][col1];
    }
}
