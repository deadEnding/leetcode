package L278_FirstBadVersion;

/**
 * @author: deadend
 * @date: 9:59 PM 7/26/16
 * @version: 1.0
 * @description: Leetcode 278. First Bad Version
 */

class VersionControl {
    boolean isBadVersion(int version) {
        if (version >= 1702766719)
            return true;
        return false;
    }
}


public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;   // 避免 int mid = (l + r) / 2 溢出
            if (isBadVersion(mid))
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstBadVersion(2126753390));
    }
}
