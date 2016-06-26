#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        vector<int>::iterator it = nums.begin();

        while (it != nums.end()) {
            if (it != nums.begin() && *it == *(it-1)) {
                it = nums.erase(it);
            } else {
                ++it;
            }
        }
        return nums.size();
    }
};


int main()
{
    vector<int> nums;
    nums.push_back(1);
    nums.push_back(2);
    nums.push_back(2);

    Solution so;
    cout << so.removeDuplicates(nums) << endl;
    for(vector<int>::size_type ix = 0; ix != nums.size(); ++ix) {
        cout << nums[ix] << endl;
    }
    return 0;
}
