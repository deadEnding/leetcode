package L367_ValidPerfectSquare;

/**
 * @author: deadend
 * @date: 10:21 PM 8/1/16
 * @version: 1.0
 * @description: Leetcode 367. Valid Perfect Square
 */


public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0)
            return false;

        long l = 0;
        long r = num;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long val = mid * mid;
            if (val == (long)num)
                return true;
            else if (val < (long)num)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new OtherSolution().isPerfectSquare(2147483647));
    }
}


class OtherSolution {

    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
