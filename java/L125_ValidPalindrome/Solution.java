package L125_ValidPalindrome;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 11:46 AM 7/16/16
 * @version: 1.0
 * @description: Leetcode 125. Valid Palindrome
 */


public class Solution {

    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();

        while (i < j) {
            while (i < j && !isValid(s.charAt(i)))
                ++i;
            while (i < j && !isValid(s.charAt(j)))
                --j;
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s =  new String("A man, a plan, a canal: Panama");
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(s));
    }
}