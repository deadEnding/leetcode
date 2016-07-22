package L198_HouseRobber;

/**
 * @author: deadend
 * @date: 10:26 AM 7/21/16
 * @version: 1.0
 * @description: Leetcode 198. House Robber
 */


public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;

        int prev = 0;
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
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
        }

        int g2 = 0;
        int g1 = nums[0];
        int g = nums[1];
        int max = Math.max(g1, g);
        for (int i = 2; i < n; i++) {
            int tmp = g;
            g = Math.max(g2, g1) + nums[i];
            max = Math.max(max, g);
            g2 = g1;
            g1 = tmp;
        }
        return max;
    }
}
