#include <iostream>
#include <vector>

using namespace std;

class Printer {
public:
    template <typename T>
    static void print(T c) {
        for (typename T::size_type ix = 0; ix != c.size(); ++ix) {
            cout << c[ix] << " ";
        }
        cout << endl;
    }
};


class Solution {
public:
    vector<vector<int> > permute(vector<int>& nums) {
        perm(nums, 0);
        return result;
    }

private:
    vector<vector<int> > result;

    void perm(vector<int>& nums, int k) {
        if (k == nums.size()-1) {
            // Printer::print(nums);
            result.push_back(nums);
            return;
        }

        for (int i = k; i < nums.size(); ++i) {
            swap(nums[k], nums[i]);
            perm(nums, k + 1);
            swap(nums[k], nums[i]);
        }
    }
};


int main()
{
    vector<int> nums;
    nums.push_back(1);
    nums.push_back(2);
    nums.push_back(3);

    Solution so;
    so.permute(nums);

    return 0;
}
