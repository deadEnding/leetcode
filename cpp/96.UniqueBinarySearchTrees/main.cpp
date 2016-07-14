#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    int numTrees(int n) {
        vector<int> f(n+1, 0);

        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int k = 0; k < i; ++k) {
                f[i] += f[k] * f[i-1-k];
            }
        }
        return f[n];
    }
};


class OtherSolution {
public:
    int numTrees(int n) {
        vector<int> nums(n+1, 0);
        return numTrees(n, nums);
    }

private:
    int numTrees(int ix, vector<int>& nums) {
        if (ix == 0 || ix == 1) {
            return 1;
        }

        if (nums[ix] == 0) {
            for (int i = 0; i < ix; ++i) {
                nums[ix] += numTrees(i, nums) * numTrees(ix - i - 1, nums);
            }
        }

        return nums[ix];
    }
};


int main()
{
    Solution so;
    cout << so.numTrees(6) << endl;
    return 0;
}
