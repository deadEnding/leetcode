#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        const int n = nums.size();
        if (n <= 2)
            return n;

        int index = 2;
        for (int i = 2; i < n; ++i) {
            if (nums[i] != nums[index-2])
                nums[index++] = nums[i];
        }
        return index;
    }
};


class OtherSolution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty())
            return 0;

        int times = 1;
        int index = 0;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[index] == nums[i] && times > 0) {
                nums[++index] = nums[i];
                --times;
            } else if (nums[index] != nums[i]){
                nums[++index] = nums[i];
                times = 1;
            }
        }
        return index + 1;
    }
};


int main()
{
    vector<int> nums{1,1,1,2,2,3};
    Solution so;
    cout << so.removeDuplicates(nums) << endl << endl;

    for (auto i : nums) {
        cout << i << " ";
    }
    return 0;
}
