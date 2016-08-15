package L076_MinimumWindowSubstring;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 5:47 PM 8/13/16
 * @version: 1.0
 * @description: Leetcode 76. Minimum Window Substring
 */

public class Solution {

    public String minWindow(String s, String t) {
        int l = 0;
        int minLeft = 0;
        int minSize = s.length() + 1;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        int count = 0;  // 只记录有效的增删操作
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                count += map.get(c) >= 0 ? 1 : 0;

                while (count == t.length()) {
                    if (r - l + 1 < minSize) {
                        minLeft = l;
                        minSize = r - l + 1;
                    }

                    char o = s.charAt(l);
                    if (map.containsKey(o)) {
                        map.put(o, map.get(o) + 1);
                        count -= map.get(o) > 0 ? 1 : 0;
                    }
                    l++;
                }
            }
        }

        return minSize > s.length() ? "" : s.substring(minLeft, minLeft + minSize);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(new Solution().minWindow(s, t));
    }
}


class OtherSolution {

    private boolean ge(HashMap<Character, Integer> map, HashMap<Character, Integer> tmap) {
        for (char c : tmap.keySet()) {
            if (!map.containsKey(c) || map.get(c) < tmap.get(c))
                return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        String result = null;
        HashMap<Character, Integer> tmap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tmap.put(c, tmap.containsKey(c) ? tmap.get(c) + 1 : 1);
        }

        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (tmap.containsKey(c)) {
                map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
                while (ge(map, tmap)) {
                    char o = s.charAt(start);
                    if (map.containsKey(o)) {
                        map.put(o, map.get(o) - 1);
                    }
                    if (result == null || result.length() > i - start + 1)
                        result = s.substring(start, i + 1);
                    start++;
                }
            }
        }

        return result == null ? "" : result;
    }
}

