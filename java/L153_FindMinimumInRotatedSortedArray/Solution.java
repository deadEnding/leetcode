package L153_FindMinimumInRotatedSortedArray;

/**
 * @author: deadend
 * @date: 8:27 PM 7/19/16
 * @version: 1.0
 * @description: Leetcode 153. Find Minimum in Rotated Sorted Array
 */


/* 保证最小值始终在nums[l:r]范围内 */
public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[r])
                l = mid + 1;
            else
                r = mid;
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {3};
        System.out.println(new Solution().findMin(nums));
    }
}
