package L299_BullsAndCows;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: deadend
 * @date: 3:47 PM 7/27/16
 * @version: 1.0
 * @description: Leetcode 299. Bulls and Cows
 */


public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                sMap.put(s, sMap.containsKey(s) ? sMap.get(s) + 1 : 1);
            }
        }

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s != g && sMap.containsKey(g) && sMap.get(g) > 0) {
                cows++;
                sMap.put(g, sMap.get(g) - 1);
            }
        }

        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1123", "0111"));
    }
}
