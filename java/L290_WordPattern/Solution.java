package L290_WordPattern;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 2:59 PM 7/27/16
 * @version: 1.0
 * @description: Leetcode 290. Word Pattern
 */


public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strArr = str.split(" ");
        if (pattern.length() != strArr.length)
            return false;

        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length();i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(strArr[i]))
                    return false;
            } else if (map.containsValue(strArr[i])) {
                return false;
            } else {
                map.put(c, strArr[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abba", "dog cat cat dog"));
    }
}
