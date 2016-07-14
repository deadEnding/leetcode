#include <iostream>
#include <vector>

using namespace std;

/* 正向 O(n), O(1) */
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int reach = 1;
        for (int i = 0; i < reach && reach < nums.size(); ++i)
            reach = max(reach, i + nums[i] + 1);

        return reach >= nums.size();
    }
};


/* 反向 O(n), O(1) */
class ReverseSolution {
public:
    bool canJump(vector<int>& nums) {
        if (nums.empty())
            return true;

        int left_most = nums.size() - 1;
        for (int i = left_most - 1; i >= 0; --i)
            if (i + nums[i] >= left_most)
                left_most = i;

        return left_most == 0;
    }
};


/* 动规 O(n), O(n) */
class DPSolution {
public:
    bool canJump(vector<int>& nums) {
        vector<int> f(nums.size(), 0);
        for (int i = 1; i < nums.size(); ++i) {
            f[i] = max(f[i-1], nums[i-1]) - 1;
            if (f[i] < 0)
                return false;
        }
        return f[nums.size() - 1] >= 0;
    }
};



/* 回溯 O(n!), O(1) */
class SlowSolution {
public:
    bool canJump(vector<int>& nums) {
        return dfs(nums, 0);
    }

private:
    bool dfs(vector<int>& nums, int ix) {
        if (ix >= nums.size() - 1)
            return true;

        for (int i = nums[ix]; i > 0; --i) {
            if (dfs(nums, ix + i))
                return true;
        }

        return false;
    }
};


int main()
{
    vector<int> nums {0, 1};
    Solution so;
    cout << so.canJump(nums) << endl;

    return 0;
}
