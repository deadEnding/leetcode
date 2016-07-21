package L154_FindMinimumInRotatedSortedArrayII;

/**
 * @author: deadend
 * @date: 9:23 PM 7/19/16
 * @version: 1.0
 * @description: Leetcode 154. Find Minimum in Rotated Sorted Array II
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
            else if (nums[mid] < nums[r])
                r = mid;
            else
                r--;
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {3,3,1,3};
        System.out.println(new Solution().findMin(nums));
    }
}
