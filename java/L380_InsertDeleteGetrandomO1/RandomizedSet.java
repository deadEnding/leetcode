package L380_InsertDeleteGetrandomO1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author: deadend
 * @date: 9:33 AM 8/4/16
 * @version: 1.0
 * @description: Leetcode 380. Insert Delete GetRandom O(1)
 */


public class RandomizedSet {

    HashMap<Integer, Integer> map;
    ArrayList<Integer> arr;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, arr.size());
        arr.add(val);
        return true;
    }

    /** Deletes a value from the set. Returns true if the set contained the specified element. */
    public boolean delete(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int ix = map.get(val);
        int lastIx = arr.size() - 1;
        if (ix < lastIx) {
            int last = arr.get(lastIx);
            arr.set(ix, last);
            map.put(last, ix);
        }
        arr.remove(lastIx);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return arr.get(rand.nextInt(arr.size()));
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(1));
        System.out.println(rs.delete(2));
        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());
        System.out.println(rs.delete(1));
        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());
    }
}
