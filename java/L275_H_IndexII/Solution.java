package L275_H_IndexII;

/**
 * @author: deadend
 * @date: 9:53 PM 7/26/16
 * @version: 1.0
 * @description: Leetcode 275. H-Index II
 */


public class Solution {
    public int hIndex(int[] citations) {
        final int n = citations.length;
        int max = 0;
        for (int i = 0; i < n; i++)
            if (n - i <= citations[i])
                max = Math.max(max, n - i);
        return max;
    }
}
