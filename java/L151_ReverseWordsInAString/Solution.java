package L151_ReverseWordsInAString;

/**
 * @author: deadend
 * @date: 3:58 PM 7/19/16
 * @version: 1.0
 * @description: Leetcode 151. Reverse Words in a String
 */


public class Solution {
    private void reverseWords(String s, int ix, StringBuffer sb) {
        if (ix >= s.length())
            return;

        int i;
        for (i = ix; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                break;
        }

        reverseWords(s, i + 1, sb);
        String sub = s.substring(ix, i);
        if (sb.length() > 0 && sub.length() > 0)
            sb.append(' ');
        sb.append(sub);
    }

    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        reverseWords(s, 0, sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords(" b ").length());
    }
}
