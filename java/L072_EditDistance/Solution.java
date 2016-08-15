package L072_EditDistance;


/**
 * @author: deadend
 * @date: 3:02 PM 8/12/16
 * @version: 1.0
 * @description: Leetcode 72. Edit Distance
 */


public class Solution {
    public int minDistance(String word1, String word2) {
        final int n1 = word1.length();
        final int n2 = word2.length();
        if (n1 == 0 || n2 == 0)
            return n1 + n2;

        int[][] d = new int[n1+1][n2+1];

        for (int i = 0; i <= n1; i++)
            d[i][0] = i;

        for (int j = 0; j <= n2; j++)
            d[0][j] = j;

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                int tmp = d[i][j] + (word1.charAt(i) == word2.charAt(j) ? 0 : 1);
                d[i+1][j+1] = Math.min(Math.min(d[i+1][j], d[i][j+1]) + 1, tmp);
            }
        }
        return d[n1][n2];
    }

    public static void main(String[] args) {
        String a = "pneumonoultramicroscopicsilicovolcanoconiosis";
        String b = "ultramicroscopically";
        System.out.println(new Solution().minDistance(a, b));
    }
}
