package L338_CountingBits;

/**
 * @author: deadend
 * @date: 8:56 PM 7/31/16
 * @version: 1.0
 * @description: Leetcode 338. Counting Bits
 */


public class Solution {
    public int[] countBits(int num) {
        int[] count = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            count[i] = count[i >> 1] + (i & 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] count = new Solution().countBits(5);
        for (int c : count) {
            System.out.print(c + "  ");
        }
    }
}
