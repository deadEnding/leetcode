package L215_KthLargestElementInAnArray;

/**
 * @author: deadend
 * @date: 10:16 AM 7/23/16
 * @version: 1.0
 * @description: Leetcode 215. Kth Largest Element in an Array
 */


public class Solution {

    // 一次快排的划分
    public int partition(int[] nums, int s, int e) {
        int pivot = nums[s];
        while (s < e) {
            while (s < e && nums[e] < pivot)
                e--;
            nums[s] = nums[e];
            while (s < e && nums[s] >= pivot)
                s++;
            nums[e] = nums[s];
        }
        nums[s] = pivot;
        return s;
    }

    // 递归查找
    private int findKthLargest(int[] nums, int k, int s, int e) {
        int ix = partition(nums, s, e);
        if (ix == k)
            return nums[k];
        else if (ix > k)
            return findKthLargest(nums, k, s, ix - 1);
        else
            return findKthLargest(nums, k , ix + 1, e);
    }

    public int findKthLargest(int[] nums, int k) {
        return  findKthLargest(nums, k - 1, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {3,2};
        System.out.println(new Solution().findKthLargest(nums, 2));
    }
}
