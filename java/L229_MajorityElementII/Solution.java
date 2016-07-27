package L229_MajorityElementII;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 6:21 PM 7/24/16
 * @version: 1.0
 * @description: Leetcode 229. Majority Element II
 */

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new LinkedList<>();
        int n1 = 0, n2 = 0;
        int c1 = 0, c2 = 0;

        for (int n : nums) {
            if (n1 == n) {
                c1++;
            } else if (n2 == n) {
                c2++;
            } else if (c1 == 0) {
                n1 = n;
                c1 = 1;
            } else if (c2 == 0) {
                n2 = n;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = c2 = 0;
        for (int n : nums) {
            if (n1 == n)
                c1++;
            else if (n2 == n)
                c2++;
        }

        if (c1 > nums.length / 3)
            result.add(n1);
        if (c2 > nums.length / 3)
            result.add(n2);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,2,1,1,3};
        List<Integer> result = new Solution().majorityElement(nums);
        for (Integer i : result)
            System.out.print(i + "  ");
        System.out.println();
    }
}


class OtherSolution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 3)
                result.add(key);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1,2,1,3};
        List<Integer> result = new Solution().majorityElement(nums);
        for (Integer i : result)
            System.out.print(i + "  ");
        System.out.println();
    }
}
