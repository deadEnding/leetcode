package L219_ContainsDuplicateII;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 11:28 AM 7/23/16
 * @version: 1.0
 * @description: Leetcode 219. Contains Duplicate II
 */


public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,1,5,6};
        System.out.println(new Solution().containsNearbyDuplicate(nums, 3));
    }
}
