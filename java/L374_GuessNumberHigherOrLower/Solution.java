package L374_GuessNumberHigherOrLower;

/**
 * @author: deadend
 * @date: 2:07 PM 8/2/16
 * @version: 1.0
 * @description: Leetcode 374. Guess Number Higher or Lower
 */

class GuessGame {
    public int guess(int num) {
        return num == 6 ? 0 : (num > 6 ? -1 : 1);
    }
}

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int ret = guess(mid);
            if (ret == 0)
                return mid;
            else if (ret == -1)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().guessNumber(10));
    }
}
