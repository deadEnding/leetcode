#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int> > combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<int> path;
        combine(candidates, 0, target, path);
        return result;
    }

private:
    vector<vector<int> > result;

    void combine(vector<int>& candidates, int ix, int remain, vector<int>& path) {
        if (remain <= 0) {
            if (remain == 0)
                result.push_back(path);
            return;
        }

        for (int i = ix; i < candidates.size(); ++i) {
            if (remain < candidates[i])   // 剪枝
                return;

            path.push_back(candidates[i]);
            combine(candidates, i, remain - candidates[i], path);
            path.pop_back();
        }
    }
};


int main()
{
    vector<int> candidates;
    candidates.push_back(2);
    candidates.push_back(3);
    candidates.push_back(6);
    candidates.push_back(7);

    Solution so;
    vector<vector<int> > result = so.combinationSum(candidates, 7);
    for (int i = 0; i < result.size(); ++i) {
        for (int j = 0; j < result[i].size(); ++j) {
            cout << result[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}
