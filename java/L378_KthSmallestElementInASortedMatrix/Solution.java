package L378_KthSmallestElementInASortedMatrix;

/**
 * @author: deadend
 * @date: 10:25 PM 8/2/16
 * @version: 1.0
 * @description: Leetcode 378. Kth Smallest Element in a Sorted Matrix
 */


public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        final int n = matrix.length;
        int[] cols = new int[n];

        int ix = 0;
        while (k-- > 0) {
            ix = 0;
            for (int i = 0; i < n; i++) {
                if (cols[ix] == n || (cols[i] < n && matrix[i][cols[i]] < matrix[ix][cols[ix]]))
                    ix = i;
            }
            cols[ix]++;
        }

        return matrix[ix][cols[ix]-1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(new Solution().kthSmallest(matrix, 9));
    }
}
