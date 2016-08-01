package L318_MaximumProductOfWordLengths;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: deadend
 * @date: 11:27 AM 7/30/16
 * @version: 1.0
 * @description: Leetcode 318. Maximum Product of Word Lengths
 */


public class Solution {
    public int maxProduct(String[] words) {
        final int SIZE = 26;
        int[] b = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++)
                b[i] |= (1 << (words[i].charAt(j) - 'a'));
        }

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((b[i] & b[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        System.out.println(new Solution().maxProduct(words));
    }
}
