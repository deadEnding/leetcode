package L165_CompareVersionNumbers;

/**
 * @author: deadend
 * @date: 9:50 AM 7/20/16
 * @version: 1.0
 * @description: Leetcode 165. Compare Version Numbers
 */


public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] subvers1 = version1.split("\\.");
        String[] subvers2 = version2.split("\\.");

        for (int i = 0; i < subvers1.length || i < subvers2.length; i++) {
            int val1 = i < subvers1.length ? Integer.parseInt(subvers1[i]) : 0;
            int val2 = i < subvers2.length ? Integer.parseInt(subvers2[i]) : 0;
            if (val1 < val2)
                return -1;
            else if (val1 > val2)
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("1.0", "1.1"));
    }
}
