package L134_GasStation;

/**
 * @author: deadend
 * @date: 8:40 PM 7/17/16
 * @version: 1.0
 * @description: Leetcode 134. Gas Station
 */


public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int subsum = 0;
        int ix = 0;

        for (int i = 0; i < gas.length; i++) {
            int delta = gas[i] - cost[i];
            sum += delta;
            subsum += delta;

            // 重新查找
            if (subsum < 0) {
                ix = i + 1;
                subsum = 0;
            }
        }

        return sum >= 0 ? ix : -1;
    }


    public static void main(String[] args) {
        int[] gas = {-4,1,2,2,-4,3};
        int[] cost = {0,0,0,0,0,0};
        Solution solution = new Solution();
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}
