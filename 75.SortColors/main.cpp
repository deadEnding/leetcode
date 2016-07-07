#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void sortColors(vector<int>& nums) {
        int p = 0;
        int q = nums.size()-1;

        for (int ix = 0;ix < q + 1;) {
            if (nums[ix] == 0)
                swap(nums[ix++], nums[p++]);
            else if (nums[ix] == 2)
                swap(nums[ix], nums[q--]);
            else
                ++ix;
        }
    }
};


int main()
{
    vector<int> nums {0,2,0,1,0};
    Solution so;
    so.sortColors(nums);
    for (auto i : nums) {
        cout << i << " ";
    }
    cout << endl;

    return 0;
}
