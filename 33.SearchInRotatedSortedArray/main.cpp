#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {
            const int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
};


class OtherSolution {
public:
    int search(vector<int>& nums, int target) {
        const int minIndex = findMin(nums);
        const int n = nums.size();
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int rmid = real(n, minIndex, mid);
            if (nums[rmid] < target)
                l = mid + 1;
            else if (nums[rmid] > target)
                r = mid - 1;
            else
                return rmid;

        }
        return -1;
    }
private:
    int real(int n, int midIndex, int ix) {
        return (ix + midIndex) % n;
    }

    int findMin(vector<int>& nums) {
        int l = 0;
        int r = nums.size() - 1;

        if (nums[l] <= nums[r])
            return l;

        while (l <= r) {
            int m = (l + r) / 2;
            if ((m == 0 && nums[0] < nums[1]) || (nums[m-1] > nums[m]))
                return m;
            else if (nums[m] > nums[r])
                l = m + 1;
            else
                r = m;
        }
        return -1;
    }
};


int main()
{
    vector<int> nums{1,3};
    Solution so;
    cout << so.search(nums, 1) << endl;

    return 0;
}
