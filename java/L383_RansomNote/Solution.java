package L383_RansomNote;

import java.util.HashMap;

/**
 * @author: deadend
 * @date: 8:55 AM 8/12/16
 * @version: 1.0
 * @description: Leetcode 383. Ransom Note
 */


public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                if (count == 1)
                    map.remove(c);
                else
                    map.put(c, map.get(c) - 1);
            }

            if (map.isEmpty())
                return true;
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canConstruct("", "aba"));
    }
}
