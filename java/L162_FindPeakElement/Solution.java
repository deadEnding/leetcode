package L162_FindPeakElement;

/**
 * @author: deadend
 * @date: 9:30 AM 7/20/16
 * @version: 1.0
 * @description: Leetcode 162. Find Peak Element
 */

public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid+1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}


class OtherSolution {
    public int findPeakElement(int[] nums) {
        final int n = nums.length;
        if (n == 1)
            return 0;

        if (nums[0] > nums[1])
            return 0;

        if (nums[n - 1] > nums[n - 2])
            return n - 1;

        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i+1])
                return i;
        }
        return -1;
    }
}
