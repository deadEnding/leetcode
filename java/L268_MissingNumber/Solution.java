package L268_MissingNumber;

/**
 * @author: deadend
 * @date: 8:18 PM 7/26/16
 * @version: 1.0
 * @description: Leetcode 268. Missing Number
 */

/* 先把[0,n]异或，再异或数组元素 */
public class Solution {
    public int missingNumber(int[] nums) {
        int xor = nums.length;   // 即n

        for (int i = 0; i < nums.length; i++)
            xor ^= (i ^ nums[i]);

        return xor;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0};
        System.out.println(new SumSolution().missingNumber(nums));
    }
}

class SumSolution {
    public int missingNumber(int[] nums) {
        long sum = nums.length * (nums.length + 1) / 2;
        for (int n : nums)
            sum -= n;
        return (int)sum;
    }
}

/* 相邻奇偶数(i,i+1)异或为1 */
class OtherSolution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        int max = Integer.MIN_VALUE;

        for (int n : nums) {
            xor ^= n;
            max = Math.max(max, n);
        }

        if (max == nums.length - 1)
            return max + 1;

        if ((max + 1) % 2 == 1)
            xor ^= max;
        xor ^= (max + 1) % 4 / 2;
        return xor;
    }
}
