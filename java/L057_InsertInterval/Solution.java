package L057_InsertInterval;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: deadend
 * @date: 11:44 AM 8/11/16
 * @version: 1.0
 * @description: Leetcode 57. Insert Interval
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    public String toString() { return start + " " + end; }
}


public class Solution {
    public int search(List<Interval> intervals, int val) {
        int l = 0;
        int r = intervals.size();

        while (l < r) {
            int mid = l + (r - l) / 2;
            Interval in = intervals.get(mid);
            if (in.start <= val && val <= in.end) {
                return mid;
            } else if (val > in.end) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = search(intervals, newInterval.start);
        int j = search(intervals, newInterval.end);
        if (i >= intervals.size()) {
            intervals.add(newInterval);
            return intervals;
        }
        Interval ini = intervals.get(i);
        Interval inj = j < intervals.size() ? intervals.get(j) : null;

        int start = Math.min(newInterval.start, ini.start);
        int end = newInterval.end;
        if (inj != null && inj.start <= newInterval.end && newInterval.end <= inj.end) {
            intervals.remove(j);
            end = inj.end;
        }
        for (int ix = j - 1; ix >= i; ix--)
            intervals.remove(ix);

        intervals.add(i, new Interval(start, end));
        return intervals;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(9,11));
        intervals.add(new Interval(12,15));
        List<Interval> result = new Solution().insert(intervals, new Interval(18,21));
        for (Interval in : result)
            System.out.println(in.toString());
    }
}
