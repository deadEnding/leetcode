package L306_AdditiveNumber;

/**
 * @author: deadend
 * @date: 1:55 PM 7/28/16
 * @version: 1.0
 * @description: Leetcode 306. Additive Number
 * @refer: https://segmentfault.com/a/1190000006080854
 */


public class Solution {
    private boolean isValid(Long x1, Long x2, String num, int start) {
        if (start == num.length())
            return true;
        x2 = x1 + x2;
        x1 = x2 - x1;
        String sum = x2.toString();
        return num.startsWith(sum, start) && isValid(x1, x2, num, start + sum.length());
    }

    public boolean isAdditiveNumber(String num) {
        final int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            if (num.charAt(0) == '0' && i > 1)
                return false;
            Long x1 = Long.parseLong(num.substring(0, i));
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (num.charAt(i) == '0' && j > 1)
                    break;
                Long x2 = Long.parseLong(num.substring(i, i + j));
                if (isValid(x1, x2, num, i + j))
                    return true;
            }
        }
        return false;
    }
}
