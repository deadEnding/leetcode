package L227_BasicCalculatorII;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 1:08 PM 7/24/16
 * @version: 1.0
 * @description: Leetcode 227. Basic Calculator II
 */


public class Solution {
    public int calculate(String s) {
        long num = 0;
        char sign = '+';
        LinkedList<Long> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (!Character.isSpaceChar(c) || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        break;
                    case '-':
                        num = - num;
                        break;
                    case '*':
                        num = stack.pop() * num;
                        break;
                    case '/':
                        num = stack.pop() / num;
                        break;
                    default:
                        break;
                }

                stack.push(num);
                num = 0;
                sign = c;
            }
        }

        while (!stack.isEmpty())
            num += stack.pop();

        return (int)num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate(" 3+5 / 2 "));
    }
}
