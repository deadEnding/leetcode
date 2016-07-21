package L166_FractionToRecurringDecimal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: deadend
 * @date: 10:20 AM 7/20/16
 * @version: 1.0
 * @description: Leetcode 166. Fraction to Recurring Decimal
 */


/* 注意符号和溢出 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";

        StringBuffer answer = new StringBuffer();
        if (numerator > 0 ^ denominator > 0) {
            answer.append('-');
        }

        long num = numerator;
        long den = denominator;

        num = Math.abs(num);
        den = Math.abs(den);

        answer.append(num / den);
        long remain = num % den;
        if (remain == 0)
            return answer.toString();

        answer.append('.');

        Map<Long, Integer> map = new HashMap<>();
        while (remain != 0) {
            if (map.containsKey(remain)) {
                int pos = map.get(remain);
                String s1 = answer.substring(0, pos);
                String s2 = answer.substring(pos);
                return s1 + "(" + s2 + ")";
            }
            map.put(remain, answer.length());
            answer.append(remain * 10 / den);
            remain = remain * 10 % den;
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fractionToDecimal(1,2));
    }
}
