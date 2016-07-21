package L171_ExcelSheetColumnNumber;

/**
 * @author: deadend
 * @date: 2:56 PM 7/20/16
 * @version: 1.0
 * @description: Leetcode 171.ExcelSheetColumnNumber
 */


public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++)
            result = result * 26 + s.charAt(i) - 'A' + 1;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("BA"));
    }
}
