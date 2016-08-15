package L287_FindTheDuplicateNumber;

/**
 * @author: deadend
 * @date: 10:27 PM 8/9/16
 * @version: 1.0
 * @description: Leetcode 287. Find the Duplicate Number
 */

/* 时间复杂度 O(n)，类似于判断链表是否有环 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int oneStep = nums.length;
        int twoStep = nums.length;

        do {
            oneStep = nums[oneStep - 1];
            twoStep = nums[nums[twoStep - 1] - 1];
        } while (oneStep != twoStep);

        oneStep = nums.length;
        while (oneStep != twoStep) {
            oneStep = nums[oneStep - 1];
            twoStep = nums[twoStep - 1];
        }

        return oneStep;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(new Solution().findDuplicate(nums));
    }
}

/* 时间复杂度 nlog(n) */
class OtherSolution {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++)
                count += nums[i] <= mid ? 1 : 0;

            if (count > mid)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }
}
