package L003_LongestSubstringWithoutRepeatingCharacters;

import java.util.Arrays;

/**
 * @author: deadend
 * @date: 2:21 PM 8/15/16
 * @version: 1.0
 * @description: Leetcode 3. Longest Substring Without Repeating Characters
 */


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] ix = new int[256];
        int max = 0;
        int start = -1;

        Arrays.fill(ix, -1);
        for (int i = 0; i < s.length(); i++) {
            int last = (int)s.charAt(i);
            if (ix[last] > start) {
                start = ix[last];
            }
            max = Math.max(max, i - start);
            ix[last] = i;
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "bbb";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
