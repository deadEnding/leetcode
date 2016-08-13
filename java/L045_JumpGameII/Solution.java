package L045_JumpGameII;


/**
 * @author: deadend
 * @date: 2:56 PM 8/10/16
 * @version: 1.0
 * @description: Leetcode 45. Jump Game II
 */


/* 广度优先遍历 O(n), O(1) */
public class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int l = 0;
        int r = 0;
        int steps = 0;

        while (l <= r) {
            steps++;
            int oldr = r;
            for (int i = l; i <= oldr; i++) {
                r = i + nums[i] > r ? i + nums[i] : r;
                if (r >= nums.length - 1)
                    return steps;
            }
            l = oldr + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new Solution().jump(nums));
    }
}

