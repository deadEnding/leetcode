#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        vector<int>::reverse_iterator rfirst = nums.rbegin();
        vector<int>::reverse_iterator rlast = nums.rend();
        vector<int>::reverse_iterator pivot = rfirst + 1;

        while (pivot != rlast && *pivot >= *(pivot-1))
            ++pivot;

        if (pivot == rlast) {
            reverse(rfirst, rlast);
            return;
        }

        vector<int>::reverse_iterator bigger = rfirst;
        while (*bigger <= *pivot) {
            ++bigger;
        }

        swap(*pivot, *bigger);
        reverse(rfirst, pivot);
    }
};


int main()
{
    vector<int> nums;
    nums.push_back(1);
    nums.push_back(2);
    nums.push_back(3);

    Solution so;
    so.nextPermutation(nums);

    for (vector<int>::size_type ix = 0; ix < nums.size(); ++ix)
        cout << nums[ix] << endl;

    return 0;
}
