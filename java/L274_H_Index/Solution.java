package L274_H_Index;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 9:02 PM 7/26/16
 * @version: 1.0
 * @description: Leetcode 274. H-Index
 */


public class Solution {
    public int hIndex(int[] citations) {
        final int n = citations.length;
        Arrays.sort(citations);
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (n - i <= citations[i])
                max = Math.max(max, n - i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] citations = {3};
        System.out.println(new Solution().hIndex(citations));
    }
}

/* 计数排序 Counting Sort */
class CountingSortSolution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] countArray = new int[n+1];  // 结果值只可能有 n+1 种情况

        for(int i=0; i<n; i++) {
            if(citations[i] >= n) countArray[n]++;
            else countArray[citations[i]]++;
        }

        if(countArray[n]>=n) return n;

        for(int i=n-1; i>=0; i--) {
            countArray[i] = countArray[i] + countArray[i+1];
            if(countArray[i]>=i) return i;
        }
        return 0;
    }
}
