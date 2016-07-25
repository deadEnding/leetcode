package L205_IsomorphicStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: deadend
 * @date: 7:37 PM 7/21/16
 * @version: 1.0
 * @description: Leetcode 205. Isomorphic Strings
 */


/* s中同一字符不能映射到t中的两个字符，且s中不能存在两个字符映射到t中的同一字符
 * 一对一映射，但映射不是等价关系
 * */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s==null || t==null) return false;
        if(s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(map.containsKey(c1)) {
                if(map.get(c1) != c2)
                    return false;
            } else {
                if (map.containsValue(c2))
                    return false;
                else
                    map.put(c1, c2);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("paper", "title"));
    }
}
