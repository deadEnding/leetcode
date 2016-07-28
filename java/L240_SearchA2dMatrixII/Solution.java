package L240_SearchA2dMatrixII;

/**
 * @author: deadend
 * @date: 9:25 AM 7/26/16
 * @version: 1.0
 * @description: Leetcode 240. Search a 2D Matrix II
 */


public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix.length == 0)
            return false;

        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] < target)
                i++;
            else
                j--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        System.out.println(new Solution().searchMatrix(matrix, 20));
    }
}
