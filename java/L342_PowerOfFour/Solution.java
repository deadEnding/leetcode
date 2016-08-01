package L342_PowerOfFour;

/**
 * @author: deadend
 * @date: 10:29 AM 7/31/16
 * @version: 1.0
 * @description: Leetcode 342. Power of Four
 */


public class Solution {
    public boolean isPowerOfFour(int num) {
        // return num > 0 && 1073741824 % num == 0 && Math.sqrt(num) * Math.sqrt(num) == num;
        // return num > 0 && !(num & (num - 1)) && (num - 1) % 3 == 0;
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) == num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour(4));
    }
}


class OtherSolution {
    public boolean isPowerOfFour(int num) {
        while (num > 0 && num % 4 == 0)
            num /= 4;
        return num == 1;
    }
}
