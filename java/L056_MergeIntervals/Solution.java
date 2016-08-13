package L056_MergeIntervals;


import java.util.*;

/**
 * @author: deadend
 * @date: 10:27 AM 8/11/16
 * @version: 1.0
 * @description: Leetcode 56. Merge Intervals
 */


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    public String toString() { return start + " " + end; }
}

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        List<Interval> result = new ArrayList<>(intervals.size());
        PriorityQueue<Interval> queue = new PriorityQueue<>(
                intervals.size(),
                new Comparator<Interval>() {
                    @Override
                    public int compare(Interval o1, Interval o2) {
                        return Integer.compare(o1.start, o2.start);
                    }
                });

        for (Interval in : intervals)
            queue.add(in);

        Interval in = queue.poll();
        int start = in.start;
        int end = in.end;
        while (!queue.isEmpty()) {
            in = queue.poll();
            if (in.start > end) {
                result.add(new Interval(start, end));
                start = in.start;
            }
            end = Math.max(end, in.end);
        }
        result.add(new Interval(start, end));

        return result;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(15,18));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(1,3));
        List<Interval> result = new OtherSolution().merge(intervals);
        for (Interval in : result)
            System.out.println(in.toString());
    }
}

class OtherSolution {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals;

        LinkedList<Interval> result = new LinkedList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });


        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval in = intervals.get(i);
            if (result.getLast().end < in.start)
                result.add(in);
            else
                result.getLast().end = Math.max(result.getLast().end, in.end);
        }

        return result;
    }
}
