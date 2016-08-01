package L331_VerifyPreorderSerializationOfABinaryTree;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: deadend
 * @date: 12:49 PM 7/31/16
 * @version: 1.0
 * @description: Leetcode 331. Verify Preorder Serialization of a Binary Tree
 */

public class Solution {

    private int helper(String[] strs, int i) {
        if (i < 0 || i == strs.length)
            return -1;
        if (strs[i].equals("#"))
            return i + 1;
        return helper(strs, helper(strs, i + 1));
    }

    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        return helper(strs, 0) == strs.length;
    }

    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(new RegexSolution().isValidSerialization(preorder));
    }
}

/* 用栈模拟也可 */
class RegexSolution {
    public boolean isValidSerialization(String preorder) {
        Pattern p = Pattern.compile("[0-9]+,#,#");
        Matcher m = p.matcher(preorder);
        while (m.find()) {
            String str = m.group();
            preorder = preorder.replaceAll("[0-9]+,#,#", "#");
            m = p.matcher(preorder);
        }
        return preorder.equals("#");
    }
}

class OtherSolution {
    private int isValid(String[] preorder, int ix) {
        if (ix == preorder.length)
            return -1;

        if (preorder[ix].equals("#"))
            return ix + 1;

        int left = isValid(preorder, ix + 1);
        if (left == -1)
            return -1;
        int right = isValid(preorder, left);
        if (right == -1)
            return -1;
        return right;
    }

    public boolean isValidSerialization(String preorder) {
        String[] po = preorder.split(",");
        return isValid(po, 0) == po.length;
    }
}
