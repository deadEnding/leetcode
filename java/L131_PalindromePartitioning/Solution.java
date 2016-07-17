package L131_PalindromePartitioning;

import java.util.*;

/**
 * @author: deadend
 * @date: 10:59 PM 7/16/16
 * @version: 1.0
 * @description: Leetcode 131. Palindrome Partitioning
 */

/* 动态规划，时间复杂度O(n^2) */
public class Solution {

    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] isPali =  new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                isPali[i][j] = (s.charAt(i) == s.charAt(j) && (j - i <= 1 || isPali[i+1][j-1]));
            }
        }

        List<List<String>>[] subParts = new List[n];
        for (int i = n - 1; i >= 0; i--) {
            subParts[i] = new LinkedList<List<String>>();
            for (int j = i; j < n; j++) {
                if (isPali[i][j]) {
                    final String pali = s.substring(i, j + 1);
                    if (j + 1 < n) {
                        for (List<String> sub : subParts[j + 1]) {
                            subParts[i].add(new LinkedList<String>(sub) {{ add(0, pali);}});
                        }
                    } else {  // j + 1 == n
                        subParts[i].add(new LinkedList<String>(){{ add(pali); }});
                    }
                }
            }
        }
        return subParts[0];
    }

    public static void main(String[] args) {
        String str = "efe";
        Solution solution = new Solution();
        List<List<String>> result = solution.partition(str);
        for (List<String> l : result) {
            for (String s : l) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}


/* 回溯, 时间复杂度O(2^n) */
class OtherSolution {

    private List<List<String>> result = new LinkedList<>();

    // 判断s[i:j]是否是回文串
    private boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

    // 回溯
    private void partition(String s, int ix, LinkedList<String> path) {
        if (ix == s.length()) {
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = ix; i < s.length(); i++) {
            if (isPalindrome(s, ix, i)) {
                path.addLast(s.substring(ix, i + 1));
                partition(s, i + 1, path);
                path.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        partition(s, 0, new LinkedList<String>());
        return result;
    }
}

