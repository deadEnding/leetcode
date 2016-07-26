package L220_ContainsDuplicateIII;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author: deadend
 * @date: 1:59 PM 7/23/16
 * @version: 1.0
 * @description: Leetcode 220. Contains Duplicate III
 */


public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1 || t < 0)
            return false;

        SortedSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            SortedSet<Long> subSet = set.subSet((long)nums[i] - t, (long)nums[i] + t + 1);
            if (!subSet.isEmpty())
                return true;

            if (i >= k)
                set.remove((long)nums[i - k]);
            set.add((long)nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,4};
        System.out.println(new Solution().containsNearbyAlmostDuplicate(nums, 1, 1));
    }
}
