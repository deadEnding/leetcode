package L307_RangeSumQuery_Mutable;

/**
 * @author: deadend
 * @date: 2:35 PM 7/28/16
 * @version: 1.0
 * @description: Leetcode 307. Range Sum Query - Mutable
 * @refer: http://www.cnblogs.com/yrbbest/p/5056739.html  http://www.cnblogs.com/lasclocker/p/4979933.html
 */



/* 线段树 */
public class NumArray {

    class SegmentTreeNode {
        int start, end;
        int sum;
        SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private SegmentTreeNode root;

    private SegmentTreeNode buildTree(int[] nums, int left, int right) {
        SegmentTreeNode root = new SegmentTreeNode(left, right);
        if (left == right) {
            root.sum = nums[left];
        } else {
            int mid = left + (right - left) / 2;
            root.left = buildTree(nums, left, mid);
            root.right = buildTree(nums, mid + 1, right);
            root.sum = root.left.sum + root.right.sum;
        }
        return root;
    }

    private void update(SegmentTreeNode root, int i, int val) {
        if (root.start == i && root.end == i) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (i <= mid) {
                update(root.left, i, val);
            } else {
                update(root.right, i, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    private int sumRange(SegmentTreeNode root, int i, int j) {
        if (root.start == i && root.end == j) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (j <= mid) {
                return sumRange(root.left, i, j);
            } else if (i > mid) {
                return sumRange(root.right, i, j);
            } else {
                return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
            }
        }
    }

    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        root = buildTree(nums, 0, nums.length - 1);
    }

    void update(int i, int val) {
        update(root, i, val);
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }


    public static void main(String[] args) {
        int[] nums = {-1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 0));
        numArray.update(0, 1);
        System.out.println(numArray.sumRange(0, 0));
    }
}


/* 把数组分为多个长度sqrt(n)的段，时间复杂度O(sqrt(n)) */
class OtherNumArray {

    int len;    // 每段的长度
    int[] b;    // 各段的和
    int[] nums;

    public OtherNumArray(int[] nums) {
        this.nums = nums;
        len = (int)Math.ceil(Math.sqrt(nums.length));
        b = new int[len];
        for (int i = 0; i < nums.length; i++) {
            b[i / len] += nums[i];
        }
    }

    void update(int i, int val) {
        b[i / len] += val - nums[i];
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        int sb = i / len;
        int eb = j / len;
        if (sb == eb) {
            for (int k = i; k <= j; k++)
                sum += nums[k];
        } else {
            for (int k = i; k < (sb + 1) * len; k++)
                sum += nums[k];
            for (int k = sb + 1; k < eb; k++)
                sum += b[k];
            for (int k = eb * len; k <= j; k++)
                sum += nums[k];
        }
        return sum;
    }
}
