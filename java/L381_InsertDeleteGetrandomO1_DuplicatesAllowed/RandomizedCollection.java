package L381_InsertDeleteGetrandomO1_DuplicatesAllowed;

import java.util.*;

/**
 * @author: deadend
 * @date: 9:59 AM 8/10/16
 * @version: 1.0
 * @description: Leetcode 381. Insert Delete GetRandom O(1) - Duplicates allowed
 */


public class RandomizedCollection {

    HashMap<Integer, Set<Integer>> map;
    ArrayList<Integer> arr;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        arr = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean nonexist = true;
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<Integer>());
        } else if (!map.get(val).isEmpty()) {
            nonexist = false;
        }
        map.get(val).add(arr.size());
        arr.add(val);
        return nonexist;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty())
            return false;

        Iterator<Integer> iter = map.get(val).iterator();
        int ix = iter.next();
        int lastIx = arr.size() - 1;
        int last = arr.get(lastIx);
        arr.remove(lastIx);
        map.get(val).remove(ix); // 先删除，否则当被删除元素和尾元素相同时会出错
        if (ix < lastIx) {
            arr.set(ix, last);
            map.get(last).add(ix);
            map.get(last).remove(lastIx);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return arr.get(rand.nextInt(arr.size()));
    }

    public static void main(String[] args) {
        // Init an empty collection.
        RandomizedCollection collection = new RandomizedCollection();

        System.out.println(collection.insert(4));
        System.out.println(collection.insert(3));
        System.out.println(collection.insert(4));
        System.out.println(collection.insert(2));
        System.out.println(collection.insert(4));

        System.out.println(collection.remove(4));
        System.out.println(collection.remove(3));
        System.out.println(collection.remove(4));
        System.out.println(collection.remove(4));

        // System.out.println(collection.getRandom());
    }
}
