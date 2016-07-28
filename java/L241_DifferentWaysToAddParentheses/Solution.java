package L241_DifferentWaysToAddParentheses;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 10:53 AM 7/26/16
 * @version: 1.0
 * @description: Leetcode 241. Different Ways to Add Parentheses
 */


public class Solution {

    public List<Integer> diffWaysToCompute(String input) {
        final int n = input.length();
        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c))
                continue;

            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));
            for (int l : left) {
                for (int r : right) {
                    result.add(c == '+' ? l + r : (c == '-' ? l - r : l * r));
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.parseInt(input));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = new Solution().diffWaysToCompute("2*3-4*5");
        for (int n : result)
            System.out.print(n + "  ");
        System.out.println();
    }
}
