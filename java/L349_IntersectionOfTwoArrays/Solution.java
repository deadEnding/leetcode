package L349_IntersectionOfTwoArrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: deadend
 * @date: 1:50 PM 8/1/16
 * @version: 1.0
 * @description: Leetcode 349. Intersection of Two Arrays
 */


public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for (int i : nums1)
            set1.add(i);

        for (int j : nums2) {
            if (set1.contains(j))
                intersect.add(j);
        }

        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer n : intersect)
            result[i++] = n;
        return result;
    }

    public static void main(String[] args) {
        int[] result = new Solution().intersection(new int[] {1,2,2,1}, new int[] {2,2});
        for (int i : result)
            System.out.println(i);
    }
}
