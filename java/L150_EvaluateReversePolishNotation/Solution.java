package L150_EvaluateReversePolishNotation;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 3:44 PM 7/19/16
 * @version: 1.0
 * @description: Leetcode 150. Evaluate Reverse Polish Notation
 */


public class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<String> stack = new LinkedList<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int val1 = Integer.parseInt(stack.pop());
                int val2 = Integer.parseInt(stack.pop());
                switch (s) {
                    case "+":
                        stack.push(val2 + val1 + "");
                        break;
                    case "-":
                        stack.push(val2 - val1 + "");
                        break;
                    case "*":
                        stack.push(val2 * val1 + "");
                        break;
                    case "/":
                        stack.push(val2 / val1 + "");
                        break;
                }
            } else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(new Solution().evalRPN(tokens));
    }
}
