package L189_RotateArray;

/**
 * @author: deadend
 * @date: 9:10 PM 7/20/16
 * @version: 1.0
 * @description: Leetcode 189. Rotate Array
 */


public class Solution {
    private void reverse(int[] nums, int s, int e) {
        while (s < e) {
            int tmp = nums[s];
            nums[s] = nums[e];
            nums[e] = tmp;
            s++;
            e--;
        }
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);   // 翻转[0:n-1]
        reverse(nums, 0, k - 1);             // 翻转[0:k-1]
        reverse(nums, k, nums.length - 1);   // 翻转[k:n-1]
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5};
        new Solution().rotate(nums, 2);
        for(int i : nums) {
            System.out.print(i + " ");
        }
    }
}
