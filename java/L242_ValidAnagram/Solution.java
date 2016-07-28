package L242_ValidAnagram;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: deadend
 * @date: 1:21 PM 7/26/16
 * @version: 1.0
 * @description: Leetcode 242. Valid Anagram
 */


public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            map.put(sc, (map.containsKey(sc) ? map.get(sc) : 0) + 1);
            char tc = t.charAt(i);
            map.put(tc, (map.containsKey(tc) ? map.get(tc) : 0) - 1);
        }

        for (int v : map.values())
            if (v != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("", ""));
    }
}


class OtherSolution {
    public boolean isAnagram(String s, String t) {
        char[]  sArr = s.toCharArray();
        char[]  tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return String.valueOf(sArr).equals(String.valueOf(tArr));
    }
}
