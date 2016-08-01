package L345_ReverseVowelsOfAString;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: deadend
 * @date: 10:35 AM 8/1/16
 * @version: 1.0
 * @description: Leetcode 345. Reverse Vowels of a String
 */


public class Solution {

    private void swap(char[] ch, int i, int j) {
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
    }

    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>(
                Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'}));

        char[] ch = s.toCharArray();
        for (int i = 0, j = ch.length - 1; i < j;) {
            if (vowels.contains(ch[i]) && vowels.contains(ch[j])) {
                swap(ch, i++, j--);
            } else {
                if (!vowels.contains(ch[i]))
                    i++;
                if (!vowels.contains(ch[j]))
                    j--;
            }
        }

        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("hello"));
    }
}
