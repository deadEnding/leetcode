package L198_HouseRobber;

/**
 * @author: deadend
 * @date: 10:26 AM 7/21/16
 * @version: 1.0
 * @description: Leetcode 198. House Robber
 */


public class Solution {
    public int rob(int[] nums) {
        final int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];

        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for (int i  = 2; i < n; i++) {
            int tmp = curr;
            curr = Math.max(prev + nums[i], curr);
            prev = tmp;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[] {2,1}));
    }
}


class OtherSolution {
    public int rob(int[] nums) {
        final int n = nums.length;
        switch (n) {
            case 0:
                return 0;
            case 1:
                return nums[0];
            case 2:
                return Math.max(nums[0], nums[1]);
        }

        int[] f = new int[n];
        f[0] = nums[0];
        f[1] = nums[1];
        f[2] = f[0] + nums[2];
        int max = Math.max(f[1], f[2]);
        for (int i = 3; i < n; i++) {
            f[i] = Math.max(f[i-3], f[i-2]) + nums[i];
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
