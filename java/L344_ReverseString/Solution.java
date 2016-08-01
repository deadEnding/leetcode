package L344_ReverseString;

/**
 * @author: deadend
 * @date: 10:27 AM 8/1/16
 * @version: 1.0
 * @description: Leetcode 344. Reverse String
 */


public class Solution {
    public String reverseString(String s) {
        if (s == null)
            return null;

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            sb.append(s.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseString("hello"));
    }
}
