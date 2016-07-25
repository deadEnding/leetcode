package L217_ContainsDuplicate;


import java.util.HashSet;

/**
 * @author: deadend
 * @date: 11:14 AM 7/23/16
 * @version: 1.0
 * @description: Leetcode 217. Contains Duplicate
 */


public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (set.contains(n))
                return true;
            set.add(n);
        }

        return false;
    }
}
