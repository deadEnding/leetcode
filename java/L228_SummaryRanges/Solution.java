package L228_SummaryRanges;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 5:16 PM 7/24/16
 * @version: 1.0
 * @description: Leetcode 228. Summary Ranges
 */


public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        if (nums.length == 0)
            return result;

        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            // 预检查
            if (i + 1 < nums.length && i + 1 - b != nums[i+1] - nums[b] || i + 1 == nums.length) {
                if (i != b) {
                    result.add(nums[b] + "->" + nums[i]);
                } else {
                    result.add(nums[b] + "");
                }
                b = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = new Solution().summaryRanges(new int[]{0,1,2,4,5,7});
        for (String s : result)
            System.out.print(s + "  ");
        System.out.println();
    }
}
