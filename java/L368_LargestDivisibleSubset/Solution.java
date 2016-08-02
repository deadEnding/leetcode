package L368_LargestDivisibleSubset;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 10:48 PM 8/1/16
 * @version: 1.0
 * @description: Leetcode 368. Largest Divisible Subset
 * @refer: https://discuss.leetcode.com/topic/50555/29-line-clear-java-dp-solution
 */


public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new LinkedList<>();
        if (nums == null || nums.length == 0)
            return result;

        int max = nums.length - 1;
        int[] f = new int[nums.length];
        int[] prev = new int[nums.length];

        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            f[i] = 1;
            prev[i] = -1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0 && f[j] + 1 > f[i]) {
                    f[i] = f[j] + 1;
                    prev[i] = j;
                }
            }
            if (f[max] < f[i])
                max = i;
        }

        for (int i = max; i != -1;) {
            result.add(nums[i]);
            i = prev[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,8};
        List<Integer> result = new Solution().largestDivisibleSubset(nums);
        for (int n : result)
            System.out.print(n + " ");
    }
}
