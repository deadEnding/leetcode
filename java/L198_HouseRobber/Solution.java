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
        System.out.println(new OtherSolution().rob(new int[] {1,1,1}));
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

        int g2 = nums[0];
        int g1 = nums[1];
        int g = nums[0] + nums[2];
        int max = Math.max(g1, g);
        for (int i = 3; i < n; i++) {
            int tmp = g;
            g = Math.max(g2, g1) + nums[i];
            max = Math.max(max, g);
            g2 = g1;
            g1 = tmp;
        }
        return max;
    }
}
