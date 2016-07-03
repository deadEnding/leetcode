#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int subSum = nums[0];
        int maxSum = subSum;

        for (int ix = 1; ix != nums.size(); ++ix) {
            subSum = max(subSum + nums[ix], nums[ix]);
            maxSum = max(subSum, maxSum);
        }

        return maxSum;
    }
};


int main()
{
    vector<int> nums{-2,1-3,4,-1,2,1,-5,4};

    Solution so;
    cout << so.maxSubArray(nums) << endl;

    return 0;
}
