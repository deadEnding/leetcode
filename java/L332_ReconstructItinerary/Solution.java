package L332_ReconstructItinerary;

import java.util.*;

/**
 * @author: deadend
 * @date: 3:00 PM 7/31/16
 * @version: 1.0
 * @description: Leetcode 332. Reconstruct Itinerary
 */


public class Solution {

    HashMap<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> path = new LinkedList<>();

    private void dfs(String from) {
        PriorityQueue<String> to = map.get(from);
        while (to != null && !to.isEmpty()) {
            String s = to.poll();
            dfs(s);
        }
        path.addFirst(from);
    }

    public List<String> findItinerary(String[][] tickets) {
        for (String[] ft : tickets) {
            if (!map.containsKey(ft[0]))
                map.put(ft[0], new PriorityQueue<String>());
            map.get(ft[0]).add(ft[1]);
        }
        dfs("JFK");
        return path;
    }

    public static void main(String[] args) {
        // String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        // String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        List<String> result = new Solution().findItinerary(tickets);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }
}
