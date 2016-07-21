package L190_ReverseBits;

import java.util.Map;

/**
 * @author: deadend
 * @date: 9:58 AM 7/21/16
 * @version: 1.0
 * @description: Leetcode 190. Reverse Bits
 */


public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++)
            result = (result << 1) | ((n >> i) & 1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(43261596));
    }
}
