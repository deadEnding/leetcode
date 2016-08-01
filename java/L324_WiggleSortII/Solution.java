package L324_WiggleSortII;

/**
 * @author: deadend
 * @date: 3:49 PM 7/30/16
 * @version: 1.0
 * @description: Leetcode 324. Wiggle Sort II
 * @refer: http://liveasatree.blogspot.com/2016/01/leetcode-wiggle-sort-ii.html
 */


/* 时间复杂度O(n), 空间复杂度O(1) */
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int median = getMedian(nums);

        int higher = 0, lower = nums.length - 1, current = 0;
        while (current <= lower) {
            if (nums[reIndex(current, nums.length)] == median) {
                current++;
            }

            else if (nums[reIndex(current, nums.length)] < median) {
                swap(nums, reIndex(current, nums.length), reIndex(lower--, nums.length));
            }
            else swap(nums, reIndex(current++, nums.length), reIndex(higher++, nums.length));
        }
    }

    private int reIndex(int index, int n) {
        return (2*index + 1) % (n | 1);
    }

    private int getMedian(int[] nums) {
        int start = 0, end = nums.length - 1, target = nums.length / 2;
        while (true) {
            swap(nums, start, (start + end) / 2);
            int swapIndex = start, current = start + 1;
            while (current <= end) {
                if (nums[current] >= nums[start]) swap(nums, ++swapIndex, current);
                current++;
            }
            swap(nums, start, swapIndex);
            if (swapIndex - start == target) return nums[swapIndex];
            else if (swapIndex - start > target) end = swapIndex - 1;
            else {
                target -= (swapIndex - start + 1);
                start = swapIndex + 1;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 3, 1};
        new Solution().wiggleSort(nums);
        for (int n : nums)
            System.out.println(n);
    }
}
