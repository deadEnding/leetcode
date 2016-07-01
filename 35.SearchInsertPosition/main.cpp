#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size();

        while (left < right) {
            int mid = (left + right) / 2;

            // 缩小范围的时候去掉小于target的元素，保留 >=target 的元素
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }
};


class IterSolution {
public:
    int searchInsert(vector<int>& nums, int target) {
        return distance(nums.begin(), lower_bound(nums.begin(), nums.end(), target));
    }

    template<typename ForwardIterator, typename T>
    ForwardIterator lower_bound(ForwardIterator first, ForwardIterator last, T value) {
        while (first != last) {
            ForwardIterator mid = first + distance(first, last) / 2;

            if (value > *mid)
                first = ++mid;
            else
                last = mid;
        }

        return first;
    }
};


class STLSolution {
public:
    int searchInsert(vector<int>& nums, int target) {
        return distance(nums.begin(), lower_bound(nums.begin(), nums.end(), target));
    }
};


class OtherSolution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] > target) {
                if (mid == 0 || nums[mid-1] < target)
                    return mid;
                else
                    right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return nums.size();
    }
};


int main()
{
    vector<int> nums;
    nums.push_back(1);


    Solution so;
    cout << so.searchInsert(nums, 2) << endl;

    return 0;
}
