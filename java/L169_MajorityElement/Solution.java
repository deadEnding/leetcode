package L169_MajorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: deadend
 * @date: 1:04 PM 7/20/16
 * @version: 1.0
 * @description: Leetcode 169. Majority Element
 */

/* Moore's voting algorithm 时间复杂度O(n)，空间复杂度O(1) */
public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int n : nums) {
            if (count == 0) {
                candidate = n;
                count++;
            } else {
                count = (n == candidate ? count + 1 : count - 1);
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,1};
        System.out.println(new BitSolution().majorityElement(nums));
    }
}


/* 位操作 时间复杂度O(n)，空间复杂度O(1) */
class BitSolution {
    public int majorityElement(int[] nums) {
        final int size = 32;
        int majority = 0;

        for (int i = 0; i < size; i++) {
            int bitCounter = 0;
            for (int n : nums)
                bitCounter += ((1 << i & n) != 0 ? 1 : 0);
            if (bitCounter > nums.length / 2)
                majority += 1 << i;
        }
        return majority;
    }
}


/* 基本思路 时间复杂度O(n)，空间复杂度O(n) */
class BasicSolution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }

            int count = map.get(i) + 1;
            if (count > nums.length / 2)
                return i;
            map.put(i, count);
        }
        return -1;
    }
}
