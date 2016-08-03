package L372_SuperPow;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 10:09 AM 8/2/16
 * @version: 1.0
 * @description: Leetcode 372. Super Pow
 */


public class Solution {
    private final int M = 1337;

    private int pow(int a, int k) {
        if (k == 0)
            return 1;

        long p = 1;
        for (int i = 0; i < k; i++)
            p = p * a % M;
        return (int)p;
    }

    private int superPow(int a, LinkedList<Integer> b) {
        if (b.isEmpty())
            return 1;
        int lastBit = b.pop();
        return pow(a, lastBit) * pow(superPow(a, b), 10) % M;
    }

    public int superPow(int a, int[] b) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int n : b)
            stack.push(n);
        return superPow(a, stack);
    }

    public static void main(String[] args) {
        int[] b = {2,0,0};
        System.out.println(new Solution().superPow(2147483647, b));
    }
}
