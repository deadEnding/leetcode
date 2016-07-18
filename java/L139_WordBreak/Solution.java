package L139_WordBreak;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: deadend
 * @date: 9:39 AM 7/18/16
 * @version: 1.0
 * @description: Leetcode 139. Word Break
 */

/* 时间复杂度O(n^2) */
public class Solution {

    public boolean wordBreak(String s, Set<String> wordDict) {
        final int n = s.length();
        boolean[][] isWord = new boolean[n][n];
        boolean[] canBreak = new boolean[n + 1];
        canBreak[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (wordDict.contains(s.substring(i, j + 1))) {
                    isWord[i][j] = true;
                    if (canBreak[j + 1]) {
                        canBreak[i] = true;
                        break;
                    }
                }
            }
        }

        return canBreak[0];
    }

    public static void main(String[] args) {
        Set<String> wordDict = new HashSet<String>() {{ add("leet"); add("code"); }};
        String s = "leetcode";
        System.out.println(new Solution().wordBreak(s, wordDict));
    }
}

/* 时间复杂度O(2^n)，超时 */
class OtherSolution {

    private boolean wordBreak(String s, Set<String> wordDict, int ix) {
        if (ix == s.length())
            return true;

        for (int i = ix; i < s.length(); i++) {
            if (wordDict.contains(s.substring(ix, i + 1)) && wordBreak(s, wordDict, i + 1))
                return true;
        }
        return false;
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        return wordBreak(s, wordDict, 0);
    }
}
