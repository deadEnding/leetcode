package L310_MinimumHeightTrees;

import java.util.*;

/**
 * @author: deadend
 * @date: 9:15 PM 7/29/16
 * @version: 1.0
 * @description: Leetcode 310. Minimum Height Trees
 * @refer: http://www.cnblogs.com/yrbbest/p/5060225.html
 */


/* 逐步删除叶子结点 */
public class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Collections.singletonList(0);

        List<Integer> leaves = new ArrayList<>();
        List<Set<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new HashSet<Integer>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++)
            if (graph.get(i).size() == 1)
                leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                for (int neighbor : graph.get(leaf)) {
                    graph.get(neighbor).remove(leaf);
                    if (graph.get(neighbor).size() == 1)
                        newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        // int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        List<Integer> result = new Solution().findMinHeightTrees(6, edges);
        for (int n : result)
            System.out.println(n);
    }
}


/* 广度优先遍历求每个根树的高度，超时 */
class OtherSolution {

    private int bfs(int ix, int n, int min, LinkedList<Integer>[] adjacent) {
        int height = 0;
        int dummy = -1;
        boolean[] visited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(ix);
        queue.offer(dummy);
        visited[ix] = true;

        while (!queue.isEmpty()) {
            int q = queue.poll();
            if (q == dummy) {
                height++;
                if (height > min)
                    return Integer.MAX_VALUE;
                if (!queue.isEmpty())
                    queue.offer(dummy);
                continue;
            }

            for (int next : adjacent[q]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return height;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new LinkedList<>();
        LinkedList<Integer>[] adjacent = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            adjacent[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            if (edge[0] != edge[1]) {
                adjacent[edge[0]].add(edge[1]);
                adjacent[edge[1]].add(edge[0]);
            }
        }

        int min = Integer.MAX_VALUE;
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = bfs(i, n, min, adjacent);
            min = Math.min(min, height[i]);
        }

        for (int i = 0; i < n; i++) {
            if (height[i] == min) {
                result.add(i);
                System.out.println(i);
            }
        }
        return result;
    }
}
