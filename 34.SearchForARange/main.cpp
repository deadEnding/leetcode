#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> result(2, -1);

        const int left = binarySearch(nums, target, true);
        if (left == -1)
            return result;

        const int right = binarySearch(nums, target, false);
        result[0] = left;
        result[1] = right;

        return result;
    }
private:
    int binarySearch(vector<int>& nums, int target, bool isLeft) {
        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else {
                if (isLeft) {
                    if (mid == 0 || nums[mid-1] < nums[mid])
                        return mid;
                    else
                        right = mid - 1;
                } else {
                    if (mid == right || nums[mid+1] > nums[mid])
                        return mid;
                    else
                        left = mid + 1;
                }
            }
        }
        return -1;
    }
};


class STLSolution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> result(2, -1);
        const int left = distance(nums.begin(), lower_bound(nums.begin(), nums.end(), target));
        if (nums[left] != target)
            return result;

        const int right =  distance(nums.begin(), upper_bound(nums.begin(), nums.end(), target)-1);
        result[0] = left;
        result[1] = right;

        return result;
    }
};


int main()
{
    vector<int> nums;
    nums.push_back(5);
    nums.push_back(7);
    nums.push_back(7);
    nums.push_back(8);
    nums.push_back(8);
    //nums.push_back(10);

    STLSolution so;
    vector<int> range = so.searchRange(nums, 8);

    cout << range[0] << " " << range[1] << endl;

    return 0;
}
