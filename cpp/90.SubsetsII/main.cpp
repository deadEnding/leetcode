#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<int> path;
        dfs(0, nums, path);
        return result;
    }

private:
    vector<vector<int>> result;

    void dfs(int ix, vector<int>& nums, vector<int>& path) {
        result.push_back(path);

        for (int i = ix; i < nums.size();++i) {
            path.push_back(nums[i]);
            dfs(i+1, nums, path);
            path.pop_back();

            while (i+1 < nums.size() && nums[i+1] == nums[i])
                ++i;
        }
    }
};


int main()
{
    vector<int> nums{1,2,2};
    Solution so;
    vector<vector<int>> result = so.subsetsWithDup(nums);
    for (auto v : result) {
        for (auto i : v)
            cout << i << " ";
        cout << endl;
    }
    cout << endl;
    return 0;
}
