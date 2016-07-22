package L202_HappyNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: deadend
 * @date: 4:40 PM 7/21/16
 * @version: 1.0
 * @description: Leetcode 202. Happy Number
 */


public class Solution {
    private int square(int n) {
        int sum = 0;
        while (n != 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            int sum = square(n);
            if (set.contains(sum))
                return false;
            else
                set.add(sum);
            n = sum;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(2));
    }
}
