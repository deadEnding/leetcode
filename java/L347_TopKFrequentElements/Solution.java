package L347_TopKFrequentElements;

import java.util.*;

/**
 * @author: deadend
 * @date: 10:58 AM 8/1/16
 * @version: 1.0
 * @description: Leetcode 347. Top K Frequent Elements
 */


public class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int n : nums)
            counter.put(n, counter.containsKey(n) ? counter.get(n) + 1 : 1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                counter.size(),
                new Comparator<Map.Entry<Integer, Integer>>() {
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o2.getValue().compareTo(o1.getValue()); // 大 -> 小
                    }
                });

        // Java 8 新特性
        // PriorityQueue<Map.Entry<Integer, Integer>> pq =
        //        new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());
        pq.addAll(counter.entrySet());

        List<Integer> topk = new ArrayList<>(k);
        for (int i = 0; i < k; i++)
            topk.add(pq.poll().getKey());

        return topk;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,3};
        List<Integer> result = new BucketSolution().topKFrequent(nums, 2);
        for (int n : result)
            System.out.println(n);
    }
}

// 桶排序
class BucketSolution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> counter = new HashMap<>();

        for (int n : nums)
            counter.put(n, counter.containsKey(n) ? counter.get(n) + 1 : 1);

        for (int key : counter.keySet()) {
            int val = counter.get(key);
            if (bucket[val] == null)
                bucket[val] = new ArrayList<>();
            bucket[val].add(key);
        }

        List<Integer> topk = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && topk.size() < k; i--) {
            if (bucket[i] != null) {
                topk.addAll(bucket[i]);
            }
        }

        return topk;
    }
}
