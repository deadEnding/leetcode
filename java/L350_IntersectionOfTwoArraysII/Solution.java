package L350_IntersectionOfTwoArraysII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: deadend
 * @date: 1:58 PM 8/1/16
 * @version: 1.0
 * @description: Leetcode 350. Intersection of Two Arrays II
 */


public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();

        for (int i : nums1)
            map1.put(i, map1.containsKey(i) ? map1.get(i) + 1 : 1);

        ArrayList<Integer> interect = new ArrayList<>();
        for (int j : nums2) {
            if (map1.containsKey(j) && map1.get(j) > 0) {
                interect.add(j);
                map1.put(j, map1.get(j) - 1);
            }
        }

        int[] result = new int[interect.size()];
        int i = 0;
        for (int n : interect)
            result[i++] = n;
        return result;
    }

    public static void main(String[] args) {
        int[] result = new Solution().intersect(new int[] {1,2,2,1}, new int[] {2,2});
        for (int i : result)
            System.out.println(i);
    }
}
