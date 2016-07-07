#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> path;
        for (int i = 0; i <= nums.size(); ++i)
            dfs(i, 0, nums, path);
        return result;
    }
private:
    vector< vector<int> > result;

    void dfs(int k, int ix, vector<int>& nums, vector<int>& path) {
        if (k == 0) {
            result.push_back(path);
            return;
        }

        for (int i = ix; i + k <= nums.size(); ++i) {
            path.push_back(nums[i]);
            dfs(k-1, i+1, nums, path);
            path.pop_back();
        }
    }
};


/* 每个元素只有选和不选两种情况 O(2^n), O(n) */
class OtherSolution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> path;
        subsets(0, nums, path);
        return result;
    }

private:
    vector<vector<int>> result;

    void subsets(int ix, vector<int>& nums, vector<int>& path) {
        if (ix == nums.size()) {
            result.push_back(path);
            return;
        }

        // 不选 nums[ix]
        subsets(ix+1, nums, path);

        // 选 nums[ix]
        path.push_back(nums[ix]);
        subsets(ix+1, nums, path);
        path.pop_back();
    }
};


class Printer {
public:
    static void print(vector<vector<int> > m) {
        for (vector<vector<int> >::size_type i = 0; i != m.size(); ++i) {
            for (vector<int>::size_type j = 0; j!= m[i].size(); ++j) {
                cout << m[i][j] << " ";
            }
            cout << endl;
        }
    }
};


int main()
{
    vector<int> nums {1,4,3,2};
    OtherSolution so;
    vector< vector<int> > result = so.subsets(nums);

    Printer::print(result);
    return 0;
}
