package L384_ShuffleAnArray;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: deadend
 * @date: 9:13 AM 8/12/16
 * @version: 1.0
 * @description: Leetcode 384. Shuffle an Array
 */


public class Solution {

    private int[] nums;
    private int[] shuffled;
    private Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        this.shuffled = Arrays.copyOf(nums, nums.length);
        this.rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        this.shuffled = Arrays.copyOf(nums, nums.length);
        return shuffled;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = shuffled.length - 1; i >= 0; i--)
            swap(shuffled, i, rand.nextInt(i + 1));
        return shuffled;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] += nums[j];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        Solution so = new Solution(nums);
        for (int n : so.shuffle())
            System.out.print(n + " ");
        System.out.println();

        for (int n : so.reset())
            System.out.print(n + " ");
        System.out.println();

        for (int n : so.shuffle())
            System.out.print(n + " ");
    }
}
