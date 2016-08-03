package L373_FindKPairsWithSmallestSums;

import java.util.*;

/**
 * @author: deadend
 * @date: 1:18 PM 8/2/16
 * @version: 1.0
 * @description: Leetcode 373. Find K Pairs with Smallest Sums
 */


public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new LinkedList<>();
        final int SIZE = Math.min(k, nums1.length * nums2.length);
        int[] index = new int[nums1.length];

        for (int i = 0; i < SIZE; i++) {
            int minIndex = 0;
            int sum = Integer.MAX_VALUE;
            for (int j = 0; j < nums1.length; j++) {
                if (index[j] < nums2.length && nums1[j] + nums2[index[j]] < sum) {
                    minIndex = j;
                    sum = nums1[j] + nums2[index[j]];
                }
            }
            result.add(new int[]{nums1[minIndex], nums2[index[minIndex]]});
            index[minIndex]++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        List<int[]> result = new Solution().kSmallestPairs(nums1, nums2, 2);
        for (int[] pair : result) {
            System.out.println(pair[0] + " " + pair[1]);
        }
    }
}
