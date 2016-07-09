#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid])
                return true;

            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else if (nums[left] == nums[mid]) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
};


int main()
{
    vector<int> nums{3,1,1};
    Solution so;
    cout << so.search(nums, 3) << endl;
    return 0;
}
