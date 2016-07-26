package L224_BasicCalculator;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 2:08 PM 7/24/16
 * @version: 1.0
 * @description: Leetcode 224. Basic Calculator
 */

public class Solution {

    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;

        LinkedList<Long> stack = new LinkedList<>();
        long result = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int curr = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i+1)))
                    curr = curr * 10 + s.charAt(++i) - '0';
                result += sign * curr;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '(') {
                stack.push(result);
                result = 0;
                stack.push((long)sign);
                sign = 1;
            } else if (c == ')') {
                result = stack.pop() * result + stack.pop();
                sign = 1;
            }
        }
        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(new RecurSolution().calculate("2147483647"));
    }
}

class RecurSolution {
    private int ix = 0;

    public int calculate(String s) {
        int result = 0;
        int sign = 1;

        for (int i = ix; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int curr = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i+1)))
                    curr = curr * 10 + s.charAt(++i) - '0';
                result += sign * curr;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                ix = i + 1;
                result += sign * calculate(s);
                i = ix;
            } else if (c == ')') {
                ix = i;
                return result;
            }
        }
        return result;
    }
}

class OtherSolution {

    private long sum(LinkedList<Long> stack) {
        long sum = 0;
        while (!stack.isEmpty() && stack.peek() != Long.MIN_VALUE)
            sum += stack.pop();
        if (!stack.isEmpty()) {
            stack.pop();
            sum *= stack.pop();
        }
        stack.push(sum);
        return sum;
    }

    public int calculate(String s) {
        LinkedList<Long> stack = new LinkedList<>();

        long num = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) && !Character.isSpaceChar(c) || i == s.length() - 1){
                if (sign == -1)
                    num = -num;
                stack.push(num);

                switch (c) {
                    case '+':
                        sign = 1;
                        break;
                    case '-':
                        sign = -1;
                        break;
                    case '(':
                        stack.push((long)sign);
                        stack.push(Long.MIN_VALUE);
                        sign = 1;
                        break;
                    case ')':
                        sum(stack);
                        sign = 1;
                        break;
                    default:
                        break;
                }

                num = 0;
                if (i == s.length() - 1)
                    sum(stack);
            }
        }

        long result = stack.pop();
        return (int)result;
    }
}
