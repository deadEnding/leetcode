package L187_RepeatedDnaSequences;


import java.util.*;

/**
 * @author: deadend
 * @date: 7:53 PM 7/20/16
 * @version: 1.0
 * @description: Leetcode 187. Repeated DNA Sequences
 */

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10)
            return new LinkedList<>();

        int mask = 0x3fffffff;
        Set<Integer> set = new HashSet<>();
        Set<String> result = new HashSet<>();

        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n = (n << 3) | (s.charAt(i) & 7);
            n &= mask;
            if (i >= 9) {
                if (set.contains(n))
                    result.add(s.substring(i - 9, i + 1));
                else
                    set.add(n);
            }
        }
        return new LinkedList<>(result);
    }

    public static void main(String[] args) {
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = new Solution().findRepeatedDnaSequences(str);
        for (String s : result) {
            System.out.println(s + " ");
        }
    }
}


class RadixSolution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10)
            return new LinkedList<>();

        final Map<Character, Integer> map = new HashMap<Character, Integer>(4) {{
            put('A',0); put('T',1); put('C',2); put('G', 3); }};

        Set<String> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();

        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n = (n << 2) + map.get(s.charAt(i));
            n &= (1 << 20) - 1;
            if (i >= 9) {
                if (set.contains(n))
                    result.add(s.substring(i - 9, i + 1));
                else
                    set.add(n);
            }
        }

        return new LinkedList<>(result);
    }
}
