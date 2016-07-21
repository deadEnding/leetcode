package L168_ExcelSheetColumnTitle;

/**
 * @author: deadend
 * @date: 10:47 AM 7/20/16
 * @version: 1.0
 * @description: Leetcode 168. Excel Sheet Column Title
 */


/* 二十六进制
 * 十进制转n进制：除n逆序取余
 */
public class Solution {
    public String convertToTitle(int n) {
        StringBuffer result = new StringBuffer();

        while (n > 0) {
            result.insert(0, (char)('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(78));
    }
}
