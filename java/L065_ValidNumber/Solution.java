package L065_ValidNumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: deadend
 * @date: 10:25 AM 8/3/16
 * @version: 1.0
 * @description: Leetcode 65. Valid Number
 */

public class Solution {
    private boolean isInteger(String s) {
        Pattern pi = Pattern.compile("^(\\-|\\+)?[0-9]+$");
        Matcher m  = pi.matcher(s);
        if (m.find())
            return true;
        return false;
    }

    private boolean isFloat(String s) {
        Pattern pf = Pattern.compile("^(\\-|\\+)?[0-9]+\\.([0-9]*)$|^(\\-|\\+)?[0-9]*\\.([0-9]+)$");
        Matcher m = pf.matcher(s);
        if (m.find())
            return true;
        return false;
    }

    private boolean isScientificNotation(String s) {
        int ix = s.indexOf('e');
        if (ix == -1 || ix != s.lastIndexOf('e'))
            return false;

        String left = s.substring(0, ix);
        String right = s.substring(ix + 1);
        if (left.equals("") || right.equals(""))
            return false;
        return (isInteger(left) || isFloat(left)) && isInteger(right);
    }

    public boolean isNumber(String s) {
        s = s.trim();
        return isInteger(s) || isFloat(s) || isScientificNotation(s);
    }


    public static void main(String[] args) {
        String s = ".";
        System.out.println(new Solution().isNumber(s));
    }
}

