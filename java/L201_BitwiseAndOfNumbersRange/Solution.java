package L201_BitwiseAndOfNumbersRange;

/**
 * @author: deadend
 * @date: 3:37 PM 7/21/16
 * @version: 1.0
 * @description: Leetcode 201. Bitwise AND of Numbers Range
 */

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rangeBitwiseAnd(3,3));
    }
}

class OtherSolution {
    public int rangeBitwiseAnd(int m, int n) {
        int result = m;
        for (int i = 30; i >= 0; i--) {
            if ((result & (1 << i)) != 0) {
                int higherBit = (1 << (i + 1));
                int remain = (higherBit - 1) & result;
                int higher = ((m - remain) | higherBit);
                if (m <= higher && higher <= n) {
                    result -= remain;
                    break;
                }
            }
        }
        return result;
    }
}
